package com.equalizer.hyosori.equalizer.presenter;


import com.equalizer.hyosori.equalizer.model.BandSet;
import com.equalizer.hyosori.equalizer.model.Eq;
import com.equalizer.hyosori.equalizer.view.SetterView;

public class SetterPresenter implements Presenter {

    private SetterView view;
    private Eq model;
    private BandSet base;
    private BandSet target;

    public SetterPresenter(SetterView view) {
        this.view = view;
        this.model = new Eq();
    }

    @Override
    public void onCreate() {
        model = new Eq();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onApplyBtnSelected(String baseName, String targetName) {
        this.base = new BandSet(baseName);
        this.target = new BandSet(targetName);

        this.view.setSeekBars(this.target.getBandSet());
        int[] a = new int[3];
        int[] A_freqList = {60, 50, 40, 30};
        int[] B_freqList = {40, 50, 60, 30};
        float[] multiply = new float[4];
        int y = 0;
        for(int i=1;i<10;i++) {
            if(A_freqList[y] > A_freqList[i]) {
                y = i;
            }
        }
        for(int i=1;i<10;i++) {
            if(B_freqList[y] > B_freqList[i]) {
                y = i;
            }
        }
        //가장작은값은 A_freqList[y] (y)번째
        for(int i=0;i<4;i++) {
            if(i==y) {
                multiply[i] = 1;
            }
            multiply[i] = A_freqList[i]/A_freqList[y];
        }
    }

    public void onSeekBarChanged(int frequency, int amplitude) {

    }
}
