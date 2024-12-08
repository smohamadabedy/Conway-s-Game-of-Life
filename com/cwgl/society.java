package com.cwgl;
import java.util.ArrayList;

public class society {

    int xDim;
    int yDim;
    int totalDim;
    int random_pop;
    
	ArrayList<Integer> init_population;
    ArrayList<ArrayList<Integer>> Society;
	
    public society(int X, int Y,int init_pop){
        this.xDim = X;
        this.yDim = Y;
        this.totalDim = X*Y;
        this.random_pop = init_pop;

        this.createSociety(this.random_pop(0,this.totalDim,random_pop));
    }

    public void createSociety(ArrayList<Integer> random_pop){
        this.Society = new ArrayList<>(this.yDim);
        for(int i=0; i < this.yDim; i++) {
            this.Society.add(new ArrayList<>(this.xDim));
        }

        int pop = 0;
        for(int y = 0; y < this.yDim; y++ ) {
            for(int x = 0; x < this.xDim; x++ ){
                if(random_pop.contains(pop++) == true) {
                    this.Society.get(y).add(1);
                }else{
                    this.Society.get(y).add(0);
                }
            }
        }
    }

    public void evolve(){
        int pop = 0;
        for(int y = 0; y < this.yDim; y++ ) {
            for(int x = 0; x < this.xDim; x++ ){
                int count = this.inspect(x,y);
                if(this.Society.get(y).get(x) == 1){
                    if(!(count  == 2 || count == 3)){
                        this.Society.get(y).set(x,0);
                    }
                }else{
                    if(count  == 3){
                        this.Society.get(y).set(x,1);
                    }
                }
            }
        }
    }

    public int inspect(int x, int y){
        int alive = 0;

        if(x > 1 && y > 1 && this.Society.get(y - 1).get(x - 1) == 1){
                alive += 1;
        }
        if(x > 1 && this.Society.get(y).get(x - 1) == 1){
            alive += 1;
        }
        if( x > 1 && y < this.yDim-1 && this.Society.get(y + 1).get(x - 1) == 1) {
            alive += 1;
        }
        if(y > 1 && this.Society.get(y-1).get(x) == 1){
            alive += 1;
        }
        if(y > 1 && x < this.xDim-1 && this.Society.get(y-1).get(x+1) == 1){
            alive += 1;
        }
        if(x < this.xDim-1 && this.Society.get(y).get(x + 1) == 1){
            alive += 1;
        }
        if(y < this.yDim-1 && this.Society.get(y+1).get(x) == 1){
            alive += 1;
        }
        if(y < this.yDim-1 && x < this.xDim-1 &&this.Society.get(y+1).get(x+1) == 1){
            alive += 1;
        }

        return alive;
    }

    public void printSociety(){
        for(int y = 0; y < this.yDim; y++ ) {
            for(int x = 0; x < this.xDim; x++ ){
                this.print(this.Society.get(y).get(x) == 0 ? '*' : 'o');
            }
            this.println("");
        }
    }

    public static void print(char str){
        System.out.print(str);
    }
    public static void println(String str){
        System.out.println(str);
    }

    /*
     random_pop
     */
    //TODO::make it private
    public ArrayList<Integer> random_pop(int min, int max, int count){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int Random;
        while(list.size() < count+1){
            Random =min +  (int)(Math.random()*(max+1));
            if(Random > max){
                continue;
            }
            list.add(Random);
        }
        return list;
    }
}
