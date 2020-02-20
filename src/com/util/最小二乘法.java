
package com.util;

import java.sql.SQLException;
import java.util.List;

import com.bean.infoBean;
import com.dao.infoDao;

/**

 * ���ߣ��ź� ���ܣ���С���˷� ���Իع飨Least squares��

 *

 * y = a x + b b = sum( y ) / n - a * sum( x ) / n a = ( n * sum( xy ) - sum( x

 * ) * sum( y ) ) / ( n * sum( x^2 ) - sum(x) ^ 2 )

 *

 */

public class ��С���˷�

{



    /*

     * �ź� ���ܣ����ع��Ƶ�yֵ

     */

    public static float estimate(float[] x, float[] y, float input)

    {

        float a = getA(x, y);

        float b = getB(x, y);

        System.out.println("���Իع�ϵ��aֵ��\t" + a + "\n" + "���Իع�ϵ��bֵ��\t" + b);

        return (a * input + b);

    }



    /*

     * �ź� ���ܣ�����x��ϵ��a ��ʽ��a = ( n sum( xy ) - sum( x ) sum( y ) ) / ( n sum( x^2 )

     * - sum(x) ^ 2 )

     */

    public static float getA(float[] x, float[] y)

    {

        int n = x.length;

        return (float) ((n * pSum(x, y) - sum(x) * sum(y)) / (n * sqSum(x) - Math

                .pow(sum(x), 2)));

    }



    /*

     * �ź� ���ܣ����س���ϵ��ϵ��b ��ʽ��b = sum( y ) / n - a sum( x ) / n

     */

    public static float getB(float[] x, float[] y)

    {

        int n = x.length;

        float a = getA(x, y);

        return sum(y) / n - a * sum(x) / n;

    }



    /*

     * �ź� ���ܣ����

     */

    private static float sum(float[] ds)

    {

        float s = 0;

        for (float d : ds)

        {

            s = s + d;

        }

        return s;

    }



    /*

     * �ź� ���ܣ���ƽ����

     */

    private static float sqSum(float[] ds)

    {

        float s = 0;

        for (float d : ds)

        {

            s = (float) (s + Math.pow(d, 2));

        }

        return s;

    }



    /*

     * �ź� ���ܣ����ض�Ӧ����˺�ĺ�

     */

    private static float pSum(float[] x, float[] y)

    {

        float s = 0;

        for (int i = 0; i < x.length; i++)

        {

            s = s + x[i] * y[i];

        }

        return s;

    }



    /*

     * �ź� ���ܣ�main()�������Իع����С���˷�javaʵ�ֺ���

     */

    public static void main(String[] args) throws SQLException

    {
    	List<String> dates=infoDao.select_he_city_date();
    	int len=dates.size();
        float[] x =new float[len];
        float[] y =new float[len];
        List<infoBean> beans=infoDao.select_he();
        for(int i=0;i<len;i++)
        {
        	x[i]=i+1;
        	y[i]=Integer.parseInt(beans.get(i).getConfirmed_num());
        	
        }
        


        System.out.println("�����Իع���yֵ��\t" + estimate(x, y,12));

    }

}
