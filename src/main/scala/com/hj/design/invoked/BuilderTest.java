package com.hj.design.invoked;

import com.hj.design.build_model.Meal;
import com.hj.design.build_model.MealBuilder;

/**
 * @author hejin-Yu
 * @desc
 */
public class BuilderTest {

    public static void main(String[] args) {

        Meal noneVegMeal = MealBuilder.prepareNoneVegMeal();
        noneVegMeal.showItesm();

    }
}
