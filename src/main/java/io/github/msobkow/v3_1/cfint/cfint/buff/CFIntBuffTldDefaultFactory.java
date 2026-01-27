
// Description: Java 25 Default Factory implementation for Tld buffers

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
 *	CFIntBuffTldFactory implementation of ICFIntTldFactory for Tld
 */
public class CFIntBuffTldDefaultFactory
	implements ICFIntTldFactory
{
	public CFIntBuffTldDefaultFactory() {
	}

	@Override
	public ICFIntTldHPKey newHPKey() {
		ICFIntTldHPKey hpkey =
			new CFIntBuffTldHPKey();
		return( hpkey );
	}

	public CFIntBuffTldHPKey ensureHPKey(ICFIntTldHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffTldHPKey) {
			return( (CFIntBuffTldHPKey)key );
		}
		else {
			CFIntBuffTldHPKey mapped = new CFIntBuffTldHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTldByTenantIdxKey newByTenantIdxKey() {
		ICFIntTldByTenantIdxKey key =
			new CFIntBuffTldByTenantIdxKey();
		return( key );
	}

	public CFIntBuffTldByTenantIdxKey ensureByTenantIdxKey(ICFIntTldByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTldByTenantIdxKey) {
			return( (CFIntBuffTldByTenantIdxKey)key );
		}
		else {
			CFIntBuffTldByTenantIdxKey mapped = new CFIntBuffTldByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTldByNameIdxKey newByNameIdxKey() {
		ICFIntTldByNameIdxKey key =
			new CFIntBuffTldByNameIdxKey();
		return( key );
	}

	public CFIntBuffTldByNameIdxKey ensureByNameIdxKey(ICFIntTldByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTldByNameIdxKey) {
			return( (CFIntBuffTldByNameIdxKey)key );
		}
		else {
			CFIntBuffTldByNameIdxKey mapped = new CFIntBuffTldByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTld newRec() {
		ICFIntTld rec =
			new CFIntBuffTld();
		return( rec );
	}

	public CFIntBuffTld ensureRec(ICFIntTld rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffTld) {
			return( (CFIntBuffTld)rec );
		}
		else {
			CFIntBuffTld mapped = new CFIntBuffTld();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntTldH newHRec() {
		ICFIntTldH hrec =
			new CFIntBuffTldH();
		return( hrec );
	}

	public CFIntBuffTldH ensureHRec(ICFIntTldH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffTldH) {
			return( (CFIntBuffTldH)hrec );
		}
		else {
			CFIntBuffTldH mapped = new CFIntBuffTldH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
