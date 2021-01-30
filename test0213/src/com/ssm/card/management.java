package com.ssm.card;

public class management {
	private  int myCardUR;
	private  int myCardSSR;
	private  int myCardSR;
	private  int myCardR;
	private  int myCardN;
    private  int UR ;
    private  int SSR ;
    private  int SR ;
    private  int R ;
    private  int N ;
    static private int diamond;
    private static int consumption;
    private int Draw_once;
    private int Draw_ten;
//    private String user;
//    private String password;
    private int Random;
    private int one;
    private int ten[] = new int[10];

    public  int getMyCardUR() {
		return myCardUR;
	}
	public  void setMyCardUR(int myCardUR) {
		this.myCardUR = myCardUR;
	}
	public  int getMyCardSSR() {
		return myCardSSR;
	}
	public  void setMyCardSSR(int myCardSSR) {
		this.myCardSSR = myCardSSR;
	}
	public  int getMyCardSR() {
		return myCardSR;
	}
	public  void setMyCardSR(int myCardSR) {
		this.myCardSR = myCardSR;
	}
	public  int getMyCardR() {
		return myCardR;
	}
	public  void setMyCardR(int myCardR) {
		this.myCardR = myCardR;
	}
	public  int getMyCardN() {
		return myCardN;
	}
	public  void setMyCardN(int myCardN) {
		this.myCardN = myCardN;
	}
	public management() {

    }
/**
 * 抽一次80點
 * @return 
 */
    public int getDraw_once() {
        Draw_once=80;
        return Draw_once;
    }

    public void setDraw_once(int Draw_once) {
        this.Draw_once = Draw_once;
    }
    /**
     * 抽10次680
     * @return 
     */

    public int getDraw_ten() {
        Draw_ten=680;
        return Draw_ten;
    }


	public void setDraw_ten(int Draw_ten) {
        this.Draw_ten = Draw_ten;
    }
    /**
     * 顯示你消耗多少鑽石
     * @return 
     */    
    public static int getConsumption() {
        return consumption;
    }
    /**
     * 累積的消費
     * 增加你消耗掉的鑽石
     * @param consumption 
     */
    

    public static void setConsumption(int consumption) {
        management.consumption += consumption;
    }


    /**
     * 抽卡片機率
     * @return 
     */

    public int getRandom() {
        Random = (int) (Math.random() * 99.999999 + 1);
        return Random;
    }
    /**
     * 抽10次的陣列
     * @return 
     */


    /**
     * 儲值鑽石
     * @param diamond 
     */

    public static void setDiamond(int diamond) {
        management.diamond += diamond;
    }
    /**
     * 抽一次產生一個亂數
     * @return 
     */

    public int getOne() {
        one = getRandom();
        return one;
    }
    /**
     * 刷新卡池用
     * @param UR 
     */
    
    public  void setUR(int UR) {
  
    	this.UR = UR;
    }
    /**
     * 刷新卡池用
     * @param SSR 
     */

    public  void setSSR(int SSR) {

    	this.SSR = SSR;
    }
    /**
     * 刷新卡池用
     * @param SR 
     */

    public  void setSR(int SR) {

    	this.SR = SR;
    }
    /**
     * 刷新卡池用
     * @param R 
     */

    public  void setR(int R) {

    	this.R = R;
    }
    /**
     * 刷新卡池用
     * @param N 
     */

    public  void setN(int N) {

    	this.N = N;
    }
/**
 * 知道現在剩幾張
 * @return 
 */
    public  int getUR() {
        return UR;
    }
/**
 * 知道現在剩幾張
 * @return 
 */
    public  int getSSR() {
        return SSR;
    }
/**
 * 知道現在剩幾張
 * @return 
 */
    public  int getSR() {
        return SR;
    }
/**
 * 知道現在剩幾張
 * @return 
 */
    public  int getR() {
        return R;
    }
/**
 * 知道現在剩幾張
 * @return 
 */
    public  int getN() {
        return N;
    }
/**
 * 知道你現在有多少鑽石
 * @return 
 */
    public static int getDiamond() {
        return diamond;
    }
//    public String getUser() {
//        return user;
//    }
//    public String getPassword() {
//        return password;
//    }
/**
 * 判斷亂數抽到什麼不重複
 * @param one
 * @return 
 */
    public String toString() {
    	return "UR= "+UR+"SSR= "+SSR+"SR= "+SR+"R= "+R+"N= "+N
    	+"myCardUR= "+myCardUR+"myCardSSR= "+myCardSSR+"myCardSR= "+myCardSR
    	+"myCardR= "+myCardR+"myCardN= "+myCardN;
    }
    
    public String test(int one) {
        String a = "";
        if (one == 1) {
            if (UR == 0) {
                one = getRandom();
                System.out.println(one);
                return test(one);
            } else {
                System.out.println(one);
                UR -= 1;
                myCardUR += 1;
                a += "抽到UR卡";
            }
        } else if (one > 1 && one <= 6) {
            if (SSR == 0) {
                one = getRandom();
                System.out.println(one);
                return test(one);
            } else {
                System.out.println(one);
                SSR -= 1;
                myCardSSR += 1;
                a += "抽到SSR卡";
            }
        } else if (one > 6 && one <= 16) {
            if (SR == 0) {
                one = getRandom();
                System.out.println(one);
                return test(one);
            } else {
                System.out.println(one);
                SR -= 1;
                myCardSR += 1;
                a += "抽到SR卡";
            }
        } else if (one > 16 && one <= 40) {
            if (R == 0) {
                one = getRandom();
                System.out.println(one);
                return test(one);
            } else {
                System.out.println(one);
                R -= 1;
                myCardR += 1;
                a += "抽到R卡";
            }
        } else {
            if (N == 0) {
                one = getRandom();
                System.out.println(one);
                return test(one);
            } else {
                System.out.println(one);
                N -= 1;
                myCardN += 1;
                a += "抽到N卡";
            }
        }
        return a;
    }
    /**
     * 
	擁有
     */

    public String test1(int UR, int SSR, int SR, int R, int N) {

        return ("您擁有的UR卡:\t" + UR + "<br>\n您擁有的SSR卡:\t" + SSR
                + "<br>\n您擁有的SR卡:\t" + SR + "<br>\n您擁有的R卡:\t" + R + "<br>\n您擁有的N卡:\t" + N);
    }
    /**
     * 
	剩餘
     */

    public String test2(int UR, int SSR, int SR, int R, int N) {

        return "UR卡剩餘:\t" + UR + "<br>\nSSR卡剩餘:\t"
                + SSR + "<br>\nSR卡剩餘:\t" + SR + "<br>\nR卡剩餘:   \t" + R
                + "<br>\nN卡剩餘:   \t" + N;
    }

}