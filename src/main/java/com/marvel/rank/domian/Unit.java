package com.marvel.rank.domian;

import java.util.List;

/**
 * 单位
 *
 * Created by Marvel on 18/12/07.
 */
public class Unit {

    private String name;
    private int hp;
    private List<Ability> abilites;

    public Unit() {
    }

    public Unit(String name, int hp, List<Ability> abilites) {
        this.name = name;
        this.hp = hp;
        this.abilites = abilites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<Ability> getAbilites() {
        return abilites;
    }

    public void setAbilites(List<Ability> abilites) {
        this.abilites = abilites;
    }
}
