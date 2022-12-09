package fr.daart;

import fr.daart.y2022.ex01.AoC202201;
import fr.daart.y2022.ex02.AoC202202;
import fr.daart.y2022.ex03.AoC202203;
import fr.daart.y2022.ex04.AoC202204;
import fr.daart.y2022.ex05.AoC202205;
import fr.daart.y2022.ex06.AoC202206;
import fr.daart.y2022.ex07.AoC202207;
import fr.daart.y2022.ex08.AoC202208;
import fr.daart.y2022.ex09.AoC202209;
import fr.daart.y2022.ex10.AoC202210;
import fr.daart.y2022.ex11.AoC202211;
import fr.daart.y2022.ex12.AoC202212;
import fr.daart.y2022.ex13.AoC202213;
import fr.daart.y2022.ex14.AoC202214;
import fr.daart.y2022.ex15.AoC202215;
import fr.daart.y2022.ex16.AoC202216;
import fr.daart.y2022.ex17.AoC202217;
import fr.daart.y2022.ex18.AoC202218;
import fr.daart.y2022.ex19.AoC202219;
import fr.daart.y2022.ex20.AoC202220;
import fr.daart.y2022.ex21.AoC202221;
import fr.daart.y2022.ex22.AoC202222;
import fr.daart.y2022.ex23.AoC202223;
import fr.daart.y2022.ex24.AoC202224;
import fr.daart.y2022.ex25.AoC202225;

public class AlgoManager {

    public static void run(int year, int day) {

        switch (year) {
            case 2022:
                switch (day) {
                    case 1 -> new AoC202201().run();
                    case 2 -> new AoC202202().run();
                    case 3 -> new AoC202203().run();
                    case 4 -> new AoC202204().run();
                    case 5 -> new AoC202205().run();
                    case 6 -> new AoC202206().run();
                    case 7 -> new AoC202207().run();
                    case 8 -> new AoC202208().run();
                    case 9 -> new AoC202209().run();
                    case 10 -> new AoC202210().run();
                    case 11 -> new AoC202211().run();
                    case 12 -> new AoC202212().run();
                    case 13 -> new AoC202213().run();
                    case 14 -> new AoC202214().run();
                    case 15 -> new AoC202215().run();
                    case 16 -> new AoC202216().run();
                    case 17 -> new AoC202217().run();
                    case 18 -> new AoC202218().run();
                    case 19 -> new AoC202219().run();
                    case 20 -> new AoC202220().run();
                    case 21 -> new AoC202221().run();
                    case 22 -> new AoC202222().run();
                    case 23 -> new AoC202223().run();
                    case 24 -> new AoC202224().run();
                    case 25 -> new AoC202225().run();
                    default -> throw new IllegalArgumentException("This day is not covered");
                }
                break;
            default:
                throw new IllegalArgumentException("This year is not covered");
        }

    }

}
