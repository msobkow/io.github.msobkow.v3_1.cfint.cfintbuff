
// Description: Java 25 Default Factory implementation for MinorVersion buffers

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
 *	CFIntBuffMinorVersionFactory implementation of ICFIntMinorVersionFactory for MinorVersion
 */
public class CFIntBuffMinorVersionDefaultFactory
	implements ICFIntMinorVersionFactory
{
	public CFIntBuffMinorVersionDefaultFactory() {
	}

	@Override
	public ICFIntMinorVersionHPKey newHPKey() {
		ICFIntMinorVersionHPKey hpkey =
			new CFIntBuffMinorVersionHPKey();
		return( hpkey );
	}

	public CFIntBuffMinorVersionHPKey ensureHPKey(ICFIntMinorVersionHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffMinorVersionHPKey) {
			return( (CFIntBuffMinorVersionHPKey)key );
		}
		else {
			CFIntBuffMinorVersionHPKey mapped = new CFIntBuffMinorVersionHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMinorVersionByTenantIdxKey newByTenantIdxKey() {
		ICFIntMinorVersionByTenantIdxKey key =
			new CFIntBuffMinorVersionByTenantIdxKey();
		return( key );
	}

	public CFIntBuffMinorVersionByTenantIdxKey ensureByTenantIdxKey(ICFIntMinorVersionByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffMinorVersionByTenantIdxKey) {
			return( (CFIntBuffMinorVersionByTenantIdxKey)key );
		}
		else {
			CFIntBuffMinorVersionByTenantIdxKey mapped = new CFIntBuffMinorVersionByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMinorVersionByMajorVerIdxKey newByMajorVerIdxKey() {
		ICFIntMinorVersionByMajorVerIdxKey key =
			new CFIntBuffMinorVersionByMajorVerIdxKey();
		return( key );
	}

	public CFIntBuffMinorVersionByMajorVerIdxKey ensureByMajorVerIdxKey(ICFIntMinorVersionByMajorVerIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffMinorVersionByMajorVerIdxKey) {
			return( (CFIntBuffMinorVersionByMajorVerIdxKey)key );
		}
		else {
			CFIntBuffMinorVersionByMajorVerIdxKey mapped = new CFIntBuffMinorVersionByMajorVerIdxKey();
			mapped.setRequiredMajorVersionId( key.getRequiredMajorVersionId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMinorVersionByNameIdxKey newByNameIdxKey() {
		ICFIntMinorVersionByNameIdxKey key =
			new CFIntBuffMinorVersionByNameIdxKey();
		return( key );
	}

	public CFIntBuffMinorVersionByNameIdxKey ensureByNameIdxKey(ICFIntMinorVersionByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffMinorVersionByNameIdxKey) {
			return( (CFIntBuffMinorVersionByNameIdxKey)key );
		}
		else {
			CFIntBuffMinorVersionByNameIdxKey mapped = new CFIntBuffMinorVersionByNameIdxKey();
			mapped.setRequiredMajorVersionId( key.getRequiredMajorVersionId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntMinorVersion newRec() {
		ICFIntMinorVersion rec =
			new CFIntBuffMinorVersion();
		return( rec );
	}

	public CFIntBuffMinorVersion ensureRec(ICFIntMinorVersion rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffMinorVersion) {
			return( (CFIntBuffMinorVersion)rec );
		}
		else {
			CFIntBuffMinorVersion mapped = new CFIntBuffMinorVersion();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntMinorVersionH newHRec() {
		ICFIntMinorVersionH hrec =
			new CFIntBuffMinorVersionH();
		return( hrec );
	}

	public CFIntBuffMinorVersionH ensureHRec(ICFIntMinorVersionH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffMinorVersionH) {
			return( (CFIntBuffMinorVersionH)hrec );
		}
		else {
			CFIntBuffMinorVersionH mapped = new CFIntBuffMinorVersionH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
