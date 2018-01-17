package com.zx.enumdemo.exp1;

enum Signal{GREEN,YELLOW,RED}

public class TrafficLight {
    Signal color = Signal.RED;
    public void change(){
        switch (color){
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "color=" + color +
                '}';
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        int i = 0;
        while (i < 50){
            i++;
            System.out.println(trafficLight);
            trafficLight.change();
        }
    }
}
