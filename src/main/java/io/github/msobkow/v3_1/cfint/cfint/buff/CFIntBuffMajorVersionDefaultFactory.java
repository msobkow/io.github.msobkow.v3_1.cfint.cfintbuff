
// Description: Java 25 Default Factory implementation for MajorVersion buffers

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
 *	CFIntBuffMajorVersionFactory implementation of ICFIntMajorVersionFactory for MajorVersion
 */
public class CFIntBuffMajorVersionDefaultFactory
	implements ICFIntMajorVersionFactory
{
	public CFIntBuffMajorVersionDefaultFactory() {
	}

	@Override
	public ICFIntMajorVersionHPKey newHPKey() {
		ICFIntMajorVersionHPKey hpkey =
			new CFIntBuffMajorVersionHPKey();
		return( hpkey );
	}

	public CFIntBuffMajorVersionHPKey ensureHPKey(ICFIntMajorVersionHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffMajorVersionHPKey) {
			return( (CFIntBuffMajorVersionHPKey)key );
		}
		else {
			CFIntBuffMajorVersionHPKey mapped = new CFIntBuffMajorVersionHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMajorVersionByTenantIdxKey newByTenantIdxKey() {
		ICFIntMajorVersionByTenantIdxKey key =
			new CFIntBuffMajorVersionByTenantIdxKey();
		return( key );
	}

	public CFIntBuffMajorVersionByTenantIdxKey ensureByTenantIdxKey(ICFIntMajorVersionByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffMajorVersionByTenantIdxKey) {
			return( (CFIntBuffMajorVersionByTenantIdxKey)key );
		}
		else {
			CFIntBuffMajorVersionByTenantIdxKey mapped = new CFIntBuffMajorVersionByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMajorVersionBySubProjectIdxKey newBySubProjectIdxKey() {
		ICFIntMajorVersionBySubProjectIdxKey key =
			new CFIntBuffMajorVersionBySubProjectIdxKey();
		return( key );
	}

	public CFIntBuffMajorVersionBySubProjectIdxKey ensureBySubProjectIdxKey(ICFIntMajorVersionBySubProjectIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffMajorVersionBySubProjectIdxKey) {
			return( (CFIntBuffMajorVersionBySubProjectIdxKey)key );
		}
		else {
			CFIntBuffMajorVersionBySubProjectIdxKey mapped = new CFIntBuffMajorVersionBySubProjectIdxKey();
			mapped.setRequiredSubProjectId( key.getRequiredSubProjectId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMajorVersionByNameIdxKey newByNameIdxKey() {
		ICFIntMajorVersionByNameIdxKey key =
			new CFIntBuffMajorVersionByNameIdxKey();
		return( key );
	}

	public CFIntBuffMajorVersionByNameIdxKey ensureByNameIdxKey(ICFIntMajorVersionByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffMajorVersionByNameIdxKey) {
			return( (CFIntBuffMajorVersionByNameIdxKey)key );
		}
		else {
			CFIntBuffMajorVersionByNameIdxKey mapped = new CFIntBuffMajorVersionByNameIdxKey();
			mapped.setRequiredSubProjectId( key.getRequiredSubProjectId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMajorVersion newRec() {
		ICFIntMajorVersion rec =
			new CFIntBuffMajorVersion();
		return( rec );
	}

	public CFIntBuffMajorVersion ensureRec(ICFIntMajorVersion rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffMajorVersion) {
			return( (CFIntBuffMajorVersion)rec );
		}
		else {
			CFIntBuffMajorVersion mapped = new CFIntBuffMajorVersion();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntMajorVersionH newHRec() {
		ICFIntMajorVersionH hrec =
			new CFIntBuffMajorVersionH();
		return( hrec );
	}

	public CFIntBuffMajorVersionH ensureHRec(ICFIntMajorVersionH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffMajorVersionH) {
			return( (CFIntBuffMajorVersionH)hrec );
		}
		else {
			CFIntBuffMajorVersionH mapped = new CFIntBuffMajorVersionH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
