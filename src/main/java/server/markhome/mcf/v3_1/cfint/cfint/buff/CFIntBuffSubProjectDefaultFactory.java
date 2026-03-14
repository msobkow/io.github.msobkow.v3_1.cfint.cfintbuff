
// Description: Java 25 Default Factory implementation for SubProject buffers

/*
 *	server.markhome.mcf.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfint.cfint.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.buff.*;

/*
 *	CFIntBuffSubProjectFactory implementation of ICFIntSubProjectFactory for SubProject
 */
public class CFIntBuffSubProjectDefaultFactory
	implements ICFIntSubProjectFactory
{
	public CFIntBuffSubProjectDefaultFactory() {
	}

	@Override
	public ICFIntSubProjectHPKey newHPKey() {
		ICFIntSubProjectHPKey hpkey =
			new CFIntBuffSubProjectHPKey();
		return( hpkey );
	}

	public CFIntBuffSubProjectHPKey ensureHPKey(ICFIntSubProjectHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffSubProjectHPKey) {
			return( (CFIntBuffSubProjectHPKey)key );
		}
		else {
			CFIntBuffSubProjectHPKey mapped = new CFIntBuffSubProjectHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntSubProjectByTenantIdxKey newByTenantIdxKey() {
		ICFIntSubProjectByTenantIdxKey key =
			new CFIntBuffSubProjectByTenantIdxKey();
		return( key );
	}

	public CFIntBuffSubProjectByTenantIdxKey ensureByTenantIdxKey(ICFIntSubProjectByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffSubProjectByTenantIdxKey) {
			return( (CFIntBuffSubProjectByTenantIdxKey)key );
		}
		else {
			CFIntBuffSubProjectByTenantIdxKey mapped = new CFIntBuffSubProjectByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntSubProjectByTopProjectIdxKey newByTopProjectIdxKey() {
		ICFIntSubProjectByTopProjectIdxKey key =
			new CFIntBuffSubProjectByTopProjectIdxKey();
		return( key );
	}

	public CFIntBuffSubProjectByTopProjectIdxKey ensureByTopProjectIdxKey(ICFIntSubProjectByTopProjectIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffSubProjectByTopProjectIdxKey) {
			return( (CFIntBuffSubProjectByTopProjectIdxKey)key );
		}
		else {
			CFIntBuffSubProjectByTopProjectIdxKey mapped = new CFIntBuffSubProjectByTopProjectIdxKey();
			mapped.setRequiredTopProjectId( key.getRequiredTopProjectId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntSubProjectByNameIdxKey newByNameIdxKey() {
		ICFIntSubProjectByNameIdxKey key =
			new CFIntBuffSubProjectByNameIdxKey();
		return( key );
	}

	public CFIntBuffSubProjectByNameIdxKey ensureByNameIdxKey(ICFIntSubProjectByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffSubProjectByNameIdxKey) {
			return( (CFIntBuffSubProjectByNameIdxKey)key );
		}
		else {
			CFIntBuffSubProjectByNameIdxKey mapped = new CFIntBuffSubProjectByNameIdxKey();
			mapped.setRequiredTopProjectId( key.getRequiredTopProjectId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntSubProject newRec() {
		ICFIntSubProject rec =
			new CFIntBuffSubProject();
		return( rec );
	}

	public CFIntBuffSubProject ensureRec(ICFIntSubProject rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffSubProject) {
			return( (CFIntBuffSubProject)rec );
		}
		else {
			CFIntBuffSubProject mapped = new CFIntBuffSubProject();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntSubProjectH newHRec() {
		ICFIntSubProjectH hrec =
			new CFIntBuffSubProjectH();
		return( hrec );
	}

	public CFIntBuffSubProjectH ensureHRec(ICFIntSubProjectH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffSubProjectH) {
			return( (CFIntBuffSubProjectH)hrec );
		}
		else {
			CFIntBuffSubProjectH mapped = new CFIntBuffSubProjectH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
