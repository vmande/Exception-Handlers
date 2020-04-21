/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InsuranceFinanceManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Vaishnavi
 */
public class InsuranceFinanceOrganization extends Organization {

    public InsuranceFinanceOrganization() {
        super(Organization.Type.InsuranceFinanceOrganization.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InsuranceFinanceManagerRole());
        return roles;
    }
    
}
