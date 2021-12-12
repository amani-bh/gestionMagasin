package tn.esprit.magasin.entity;

import org.springframework.security.core.GrantedAuthority;
public enum RoleName implements GrantedAuthority { 
	ADMIN,SUPERADMIN,CLIENT;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return "ROLE_" + name();
	}
	}