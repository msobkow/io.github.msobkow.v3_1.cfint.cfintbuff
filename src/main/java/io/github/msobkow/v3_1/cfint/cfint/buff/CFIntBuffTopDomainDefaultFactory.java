
// Description: Java 25 Default Factory implementation for TopDomain buffers

/*
 *	io.github.msobkow.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
 *	
 *	Mark's Code Fractal CFInt is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFInt is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFInt is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFInt.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 *	
 */

package io.github.msobkow.v3_1.cfint.cfint.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cflib.xml.CFLibXmlUtil;
import io.github.msobkow.v3_1.cfsec.cfsec.*;
import io.github.msobkow.v3_1.cfint.cfint.*;
import io.github.msobkow.v3_1.cfsec.cfsec.buff.*;

/*
 *	CFIntBuffTopDomainFactory implementation of ICFIntTopDomainFactory for TopDomain
 */
public class CFIntBuffTopDomainDefaultFactory
	implements ICFIntTopDomainFactory
{
	public CFIntBuffTopDomainDefaultFactory() {
	}

	@Override
	public ICFIntTopDomainHPKey newHPKey() {
		ICFIntTopDomainHPKey hpkey =
			new CFIntBuffTopDomainHPKey();
		return( hpkey );
	}

	public CFIntBuffTopDomainHPKey ensureHPKey(ICFIntTopDomainHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffTopDomainHPKey) {
			return( (CFIntBuffTopDomainHPKey)key );
		}
		else {
			CFIntBuffTopDomainHPKey mapped = new CFIntBuffTopDomainHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomainByTenantIdxKey newByTenantIdxKey() {
		ICFIntTopDomainByTenantIdxKey key =
			new CFIntBuffTopDomainByTenantIdxKey();
		return( key );
	}

	public CFIntBuffTopDomainByTenantIdxKey ensureByTenantIdxKey(ICFIntTopDomainByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopDomainByTenantIdxKey) {
			return( (CFIntBuffTopDomainByTenantIdxKey)key );
		}
		else {
			CFIntBuffTopDomainByTenantIdxKey mapped = new CFIntBuffTopDomainByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomainByTldIdxKey newByTldIdxKey() {
		ICFIntTopDomainByTldIdxKey key =
			new CFIntBuffTopDomainByTldIdxKey();
		return( key );
	}

	public CFIntBuffTopDomainByTldIdxKey ensureByTldIdxKey(ICFIntTopDomainByTldIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopDomainByTldIdxKey) {
			return( (CFIntBuffTopDomainByTldIdxKey)key );
		}
		else {
			CFIntBuffTopDomainByTldIdxKey mapped = new CFIntBuffTopDomainByTldIdxKey();
			mapped.setRequiredTldId( key.getRequiredTldId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomainByNameIdxKey newByNameIdxKey() {
		ICFIntTopDomainByNameIdxKey key =
			new CFIntBuffTopDomainByNameIdxKey();
		return( key );
	}

	public CFIntBuffTopDomainByNameIdxKey ensureByNameIdxKey(ICFIntTopDomainByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopDomainByNameIdxKey) {
			return( (CFIntBuffTopDomainByNameIdxKey)key );
		}
		else {
			CFIntBuffTopDomainByNameIdxKey mapped = new CFIntBuffTopDomainByNameIdxKey();
			mapped.setRequiredTldId( key.getRequiredTldId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomain newRec() {
		ICFIntTopDomain rec =
			new CFIntBuffTopDomain();
		return( rec );
	}

	public CFIntBuffTopDomain ensureRec(ICFIntTopDomain rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffTopDomain) {
			return( (CFIntBuffTopDomain)rec );
		}
		else {
			CFIntBuffTopDomain mapped = new CFIntBuffTopDomain();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntTopDomainH newHRec() {
		ICFIntTopDomainH hrec =
			new CFIntBuffTopDomainH();
		return( hrec );
	}

	public CFIntBuffTopDomainH ensureHRec(ICFIntTopDomainH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffTopDomainH) {
			return( (CFIntBuffTopDomainH)hrec );
		}
		else {
			CFIntBuffTopDomainH mapped = new CFIntBuffTopDomainH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
