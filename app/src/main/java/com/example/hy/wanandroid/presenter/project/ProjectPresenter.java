package com.example.hy.wanandroid.presenter.project;

import com.example.hy.wanandroid.base.presenter.BaseFragmentPresenter;
import com.example.hy.wanandroid.contract.project.ProjectContract;
import com.example.hy.wanandroid.model.DataModel;
import com.example.hy.wanandroid.model.network.DefaultObserver;
import com.example.hy.wanandroid.entity.Tab;
import com.example.hy.wanandroid.utlis.RxUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * 项目Presenter
 * Created by 陈健宇 at 2018/10/23
 */
public class ProjectPresenter extends BaseFragmentPresenter<ProjectContract.View> implements ProjectContract.Presenter{


    @Inject
    public ProjectPresenter(DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void loadProjectList() {
        addSubscriber(
                mModel.getProjectList()
                .compose(RxUtils.switchSchedulers())
                .compose(RxUtils.handleRequest2())
                .subscribeWith(new DefaultObserver<List<Tab>>(mView ) {
                    @Override
                    public void onNext(List<Tab> projects) {
                        super.onNext(projects);
                        mView.showProjectList(projects);
                    }
                }));
    }

    @Override
    public void setCurrentItem(int pos) {
        mModel.setCurProjectItem(pos);
    }

    @Override
    public int getCurrentItem() {
        return mModel.getCurProjectItem();
    }
}
