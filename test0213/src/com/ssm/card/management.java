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
 * ��@��80�I
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
     * ��10��680
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
     * ��ܧA���Ӧh���p��
     * @return 
     */    
    public static int getConsumption() {
        return consumption;
    }
    /**
     * �ֿn�����O
     * �W�[�A���ӱ����p��
     * @param consumption 
     */
    

    public static void setConsumption(int consumption) {
        management.consumption += consumption;
    }


    /**
     * ��d�����v
     * @return 
     */

    public int getRandom() {
        Random = (int) (Math.random() * 99.999999 + 1);
        return Random;
    }
    /**
     * ��10�����}�C
     * @return 
     */


    /**
     * �x���p��
     * @param diamond 
     */

    public static void setDiamond(int diamond) {
        management.diamond += diamond;
    }
    /**
     * ��@�����ͤ@�Ӷü�
     * @return 
     */

    public int getOne() {
        one = getRandom();
        return one;
    }
    /**
     * ��s�d����
     * @param UR 
     */
    
    public  void setUR(int UR) {
  
    	this.UR = UR;
    }
    /**
     * ��s�d����
     * @param SSR 
     */

    public  void setSSR(int SSR) {

    	this.SSR = SSR;
    }
    /**
     * ��s�d����
     * @param SR 
     */

    public  void setSR(int SR) {

    	this.SR = SR;
    }
    /**
     * ��s�d����
     * @param R 
     */

    public  void setR(int R) {

    	this.R = R;
    }
    /**
     * ��s�d����
     * @param N 
     */

    public  void setN(int N) {

    	this.N = N;
    }
/**
 * ���D�{�b�ѴX�i
 * @return 
 */
    public  int getUR() {
        return UR;
    }
/**
 * ���D�{�b�ѴX�i
 * @return 
 */
    public  int getSSR() {
        return SSR;
    }
/**
 * ���D�{�b�ѴX�i
 * @return 
 */
    public  int getSR() {
        return SR;
    }
/**
 * ���D�{�b�ѴX�i
 * @return 
 */
    public  int getR() {
        return R;
    }
/**
 * ���D�{�b�ѴX�i
 * @return 
 */
    public  int getN() {
        return N;
    }
/**
 * ���D�A�{�b���h���p��
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
 * �P�_�üƩ�줰�򤣭���
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
                a += "���UR�d";
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
                a += "���SSR�d";
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
                a += "���SR�d";
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
                a += "���R�d";
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
                a += "���N�d";
            }
        }
        return a;
    }
    /**
     * 
	�֦�
     */

    public String test1(int UR, int SSR, int SR, int R, int N) {

        return ("�z�֦���UR�d:\t" + UR + "<br>\n�z�֦���SSR�d:\t" + SSR
                + "<br>\n�z�֦���SR�d:\t" + SR + "<br>\n�z�֦���R�d:\t" + R + "<br>\n�z�֦���N�d:\t" + N);
    }
    /**
     * 
	�Ѿl
     */

    public String test2(int UR, int SSR, int SR, int R, int N) {

        return "UR�d�Ѿl:\t" + UR + "<br>\nSSR�d�Ѿl:\t"
                + SSR + "<br>\nSR�d�Ѿl:\t" + SR + "<br>\nR�d�Ѿl:   \t" + R
                + "<br>\nN�d�Ѿl:   \t" + N;
    }

}