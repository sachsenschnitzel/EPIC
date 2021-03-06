/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sachsenschnitzel.epic.maths.parser;

import com.frequem.epic.mathematics.parser.Parser;
import com.sachsenschnitzel.epic.maths.MathObject;
import com.sachsenschnitzel.epic.maths.term.Constant;
import com.sachsenschnitzel.epic.maths.term.Term;

/**
 *
 * @author user
 */
public class ConstantParser extends Parser{
    @Override
    public Term tryParse(String data){
        try{
            return new Constant(Double.parseDouble(data));
        }catch(NumberFormatException nfe){
            return null;
        }
    }
}
