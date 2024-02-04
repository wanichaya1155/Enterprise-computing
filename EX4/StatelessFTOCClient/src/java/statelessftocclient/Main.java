/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package statelessftocclient;

import javax.ejb.EJB;
import mybeans.FTOCBeanRemote;

/**
 *
 * @author Heachanee
 */
public class Main {

    @EJB
    private static FTOCBeanRemote fTOCBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Enter degree in Fahrenheit : " + fTOCBean.fToC(32));
    }
    
}
