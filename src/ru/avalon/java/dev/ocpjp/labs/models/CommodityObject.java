/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.ocpjp.labs.models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Наташка
 */
public class CommodityObject implements Commodity, Cloneable {

    private String code;
    private String name;
    private double price;
    private int residue;
    private String vendorCode;
    

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getVendorCode() {
        return vendorCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getResidue() {
        return residue;
    }

    @Override
    protected CommodityObject clone() {
        try {
            return (CommodityObject) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    static CommodityBuilder builder(){
        return new CommodityObjectBuilder(); 
 
    }
    
    static class CommodityObjectBuilder implements CommodityBuilder{

        private final CommodityObject co = new CommodityObject();
        
        
        
        
        @Override
        public CommodityBuilder code(String code) {
            co.code =code;
            return this;
        }

        @Override
        public CommodityBuilder vendorCode(String vendorCode) {
           co.vendorCode=vendorCode;
           return this;
        }

        @Override
        public CommodityBuilder name(String name) {
            co.name = name;
            return this;
        }

        @Override
        public CommodityBuilder price(double price) {
            co.price = price;
            return this;
        }

        @Override
        public CommodityBuilder residue(int residue) {
            co.residue = residue;
            return this;
        }

        @Override
        public Commodity build() {
               return co.clone();
            
        }
        
    }
    
}
