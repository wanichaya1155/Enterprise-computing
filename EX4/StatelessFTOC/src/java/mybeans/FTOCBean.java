/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mybeans;

import javax.ejb.Stateless;

/**
 *
 * @author Heachanee
 */
@Stateless
public class FTOCBean implements FTOCBeanRemote {

    @Override
    public double fToC(double F) {
        double C = (5/9)*(F -32);
        return C;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
