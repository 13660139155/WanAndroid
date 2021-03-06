package com.example.hy.wanandroid.contract.hierarchy;

import com.example.hy.wanandroid.base.view.IView;
import com.example.hy.wanandroid.entity.Article;

import java.util.List;

/**
 * 第二级体系文章列表的Contract
 * Created by 陈健宇 at 2018/10/28
 */
public interface HierarchySecondContract {

    interface View extends IView {
        void showArticles(List<Article> articleList);
        void showMoreArticles(List<Article> articleList);
        void topping();//置顶
        void collectArticleSuccess();//收藏文章成功
        void unCollectArticleSuccess();//取消收藏成功
        void collect();
        void refreshCollections(List<Integer> ids);//刷新文章列表中的收藏
    }

    interface Presenter{
        void loadArticles(int pageNum, int id);
        void loadMoreArticles(int pageNum, int id);
        void collectArticle(int id);//收藏文章
        void unCollectArticle(int id);//取消收藏
    }

}
