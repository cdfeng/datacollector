package com.wsn.datacollector.model;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by lufen on 2017/8/6.
 */
public class FingerprintDecorator {

    private Fingerprint fingerprint;

    private int[] valueArr = new int[26];//指纹值数组

    private List<FingerprintDecorator> neighbors = new LinkedList<>();//相邻指纹的map

    public FingerprintDecorator(Fingerprint fingerprint) {
        this.fingerprint = fingerprint;
        try{
            for(int i=0; i<26; ++i ){
                Method method = Fingerprint.class.getMethod("getL"+(i+1));
                Integer value = (Integer) method.invoke(this);
                if(value == null){
                    valueArr[i] = 0;
                }else{
                    valueArr[i] = value;
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Fingerprint getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(Fingerprint fingerprint) {
        this.fingerprint = fingerprint;
    }

    public int[] getValueArr() {
        return valueArr;
    }

    public void setValueArr(int[] valueArr) {
        this.valueArr = valueArr;
    }

    public List<FingerprintDecorator> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<FingerprintDecorator> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbors(FingerprintDecorator fingerprintDecorator){
        this.neighbors.add(fingerprintDecorator);
    }
    public void removeNeighbors(FingerprintDecorator fingerprintDecorator){
        neighbors.remove(fingerprintDecorator);
    }

    public Integer getId() {
        return fingerprint.getId();
    }

    public void setId(Integer id) {
        fingerprint.setId(id) ;
    }
    public Integer getPosition() {
        return fingerprint.getPosition();
    }

    public void setPosition(Integer position) {
        fingerprint.setPosition(position);
    }

    public Long getPath() {
        return fingerprint.getPath();
    }

    public void setPath(Long path) {
        fingerprint.setPath(path);
    }

    public Long getTime() {
        return fingerprint.getTime();
    }

    public void setTime(Long time) {
        fingerprint.setTime(time);
    }

    //TODO get set methods
}