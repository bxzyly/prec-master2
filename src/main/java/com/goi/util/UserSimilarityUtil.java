package com.goi.util;

import com.goi.dto.RecommendPercent;
import com.goi.dto.SimilarityPercent;
import com.goi.dto.UserMaping;
import java.util.*;

public class UserSimilarityUtil {
    public static Map setUserSimilarity(List<UserMaping> userMapingList){
        int N = userMapingList.size();
        double[][] sparseMatrix = new double[N][N];//建立用户稀疏矩阵，用于用户相似度计算【相似度矩阵】
        Map<Integer, Integer> userItemLength = new HashMap<>();//存储每一个用户对应的不同物品总数  eg: A 3
        Map<Integer, Set<Integer>> itemUserCollection = new HashMap<>();//建立物品到用户的倒排表 eg: a A B
        Set<Integer> items = new HashSet<>();//辅助存储物品集合
        Map<Integer, Integer> userID = new HashMap<>();//辅助存储每一个用户的用户ID映射
        Map<Integer, Integer> idUser = new HashMap<>();//辅助存储每一个ID对应的用户映射

        Map<Integer, Set<SimilarityPercent>> userSimilaritysPercent = new HashMap<>(); //存储用户相似度
        Map<Integer, Set<RecommendPercent>> userArticleRecommendPercent = new HashMap<>(); //存储用户推荐度


        for(int i = 0; i < N ; i++){//依次处理N个用户 输入数据  以空格间隔
            UserMaping userMaping = userMapingList.get(i);
            int[] user_item = userMaping.getArticleId();
            int length = user_item.length;
            userItemLength.put(userMaping.getUserId(), length);//eg: A 3
            userID.put(userMaping.getUserId(), i);//用户ID与稀疏矩阵建立对应关系
            idUser.put(i, userMaping.getUserId());
            //建立物品--用户倒排表
            for(int j = 0; j < length; j ++){
                if(items.contains(user_item[j])){//如果已经包含对应的物品--用户映射，直接添加对应的用户
                    itemUserCollection.get(user_item[j]).add(userMaping.getUserId());
                }else{//否则创建对应物品--用户集合映射
                    items.add(user_item[j]);
                    itemUserCollection.put(user_item[j], new HashSet<Integer>());//创建物品--用户倒排关系
                    itemUserCollection.get(user_item[j]).add(userMaping.getUserId());
                }
            }
        }

        Set<Map.Entry<Integer, Set<Integer>>> entrySet = itemUserCollection.entrySet();
        Iterator<Map.Entry<Integer, Set<Integer>>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Set<Integer> commonUsers = iterator.next().getValue();
            for (Integer user_u : commonUsers) {
                for (Integer user_v : commonUsers) {
                    if(user_u.equals(user_v)){
                        continue;
                    }
                    sparseMatrix[userID.get(user_u)][userID.get(user_v)] +=
                            1/(Math.log(1)+commonUsers.size());//计算用户u与用户v都有正反馈的物品总数
                }
            }
        }

        //计算用户之间的相似性
        for(int i=0;i<N;i++){
            Integer recommendUser = userMapingList.get(i).getUserId();
            //计算用户之间的相似度【余弦相似性】
            int recommendUserId = userID.get(recommendUser);
            Set<SimilarityPercent> similarityPercentSet = new HashSet<>();
            for (int j = 0;j < sparseMatrix.length; j++) {
                if(j != recommendUserId){
                    double similarity = sparseMatrix[recommendUserId][j]
                            /Math.sqrt(userItemLength.get(idUser.get(recommendUserId))
                            *userItemLength.get(idUser.get(j)));
                    SimilarityPercent similarityPercent = new SimilarityPercent(idUser.get(j),similarity);
                    similarityPercentSet.add(similarityPercent);
                }else {
                    SimilarityPercent similarityPercent = new SimilarityPercent(idUser.get(j),-1);
                    similarityPercentSet.add(similarityPercent);
                }
            }

            userSimilaritysPercent.put(recommendUser,similarityPercentSet);
        }

        //计算指定用户recommendUser的物品推荐度
        for(int i=0;i<N;i++){
            Integer recommendUser = userMapingList.get(i).getUserId();
            Set<RecommendPercent> recommendPercentSet = new HashSet<>();
            for(Integer item: items){//遍历每一件物品
                Set<Integer> users = itemUserCollection.get(item);//得到购买当前物品的所有用户集合
                if(!users.contains(recommendUser)){//如果被推荐用户没有购买当前物品，则进行推荐度计算
                    double itemRecommendDegree = 0.0;
                    for(Integer user: users){
                        itemRecommendDegree +=
                                sparseMatrix[userID.get(recommendUser)][userID.get(user)]
                                        /Math.sqrt(userItemLength.get(recommendUser)
                                        *userItemLength.get(user));//推荐度计算
                    }
                    recommendPercentSet.add(new RecommendPercent(item,itemRecommendDegree));
                    System.out.println("The item "+item+" for "+recommendUser +"'s recommended degree:"+itemRecommendDegree);
                }
            }
            userArticleRecommendPercent.put(recommendUser,recommendPercentSet);
        }
        Map<String,Object> result = new HashMap<>();
        result.put("userSimilaritysPercent",userSimilaritysPercent);
        result.put("userArticleRecommendPercent",userArticleRecommendPercent);
        return result;
    }

    public static void main(String[] args) {
        List<UserMaping> userMapingList = new ArrayList<>();
        UserMaping userMaping = new UserMaping(1,new int[]{1,3,4});
        userMapingList.add(userMaping);
        UserMaping userMaping1 = new UserMaping(2,new int[]{3,3,5});
        userMapingList.add(userMaping1);
        UserMaping userMaping2 = new UserMaping(4,new int[]{15,3,6});
        userMapingList.add(userMaping2);
        UserMaping userMaping3 = new UserMaping(3,new int[]{5,3,3});
        userMapingList.add(userMaping3);
        Map result = setUserSimilarity(userMapingList);

        Map<Integer, Set<SimilarityPercent>> userSimilaritysPercent = (Map<Integer, Set<SimilarityPercent>>)result.get("userSimilaritysPercent");
        Map<Integer, Set<RecommendPercent>> userArticleRecommendPercent = (Map<Integer, Set<RecommendPercent>>)result.get("userArticleRecommendPercent");
        System.out.println("end");
        //存储用户推荐度

    }
}
