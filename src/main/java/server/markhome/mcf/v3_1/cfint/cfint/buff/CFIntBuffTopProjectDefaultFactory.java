
// Description: Java 25 Default Factory implementation for TopProject buffers

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
 *	CFIntBuffTopProjectFactory implementation of ICFIntTopProjectFactory for TopProject
 */
public class CFIntBuffTopProjectDefaultFactory
	implements ICFIntTopProjectFactory
{
	public CFIntBuffTopProjectDefaultFactory() {
	}

	@Override
	public ICFIntTopProjectHPKey newHPKey() {
		ICFIntTopProjectHPKey hpkey =
			new CFIntBuffTopProjectHPKey();
		return( hpkey );
	}

	public CFIntBuffTopProjectHPKey ensureHPKey(ICFIntTopProjectHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFIntBuffTopProjectHPKey) {
			return( (CFIntBuffTopProjectHPKey)key );
		}
		else {
			CFIntBuffTopProjectHPKey mapped = new CFIntBuffTopProjectHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopProjectByTenantIdxKey newByTenantIdxKey() {
		ICFIntTopProjectByTenantIdxKey key =
			new CFIntBuffTopProjectByTenantIdxKey();
		return( key );
	}

	public CFIntBuffTopProjectByTenantIdxKey ensureByTenantIdxKey(ICFIntTopProjectByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopProjectByTenantIdxKey) {
			return( (CFIntBuffTopProjectByTenantIdxKey)key );
		}
		else {
			CFIntBuffTopProjectByTenantIdxKey mapped = new CFIntBuffTopProjectByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopProjectByTopDomainIdxKey newByTopDomainIdxKey() {
		ICFIntTopProjectByTopDomainIdxKey key =
			new CFIntBuffTopProjectByTopDomainIdxKey();
		return( key );
	}

	public CFIntBuffTopProjectByTopDomainIdxKey ensureByTopDomainIdxKey(ICFIntTopProjectByTopDomainIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopProjectByTopDomainIdxKey) {
			return( (CFIntBuffTopProjectByTopDomainIdxKey)key );
		}
		else {
			CFIntBuffTopProjectByTopDomainIdxKey mapped = new CFIntBuffTopProjectByTopDomainIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopProjectByNameIdxKey newByNameIdxKey() {
		ICFIntTopProjectByNameIdxKey key =
			new CFIntBuffTopProjectByNameIdxKey();
		return( key );
	}

	public CFIntBuffTopProjectByNameIdxKey ensureByNameIdxKey(ICFIntTopProjectByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFIntBuffTopProjectByNameIdxKey) {
			return( (CFIntBuffTopProjectByNameIdxKey)key );
		}
		else {
			CFIntBuffTopProjectByNameIdxKey mapped = new CFIntBuffTopProjectByNameIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFIntTopProject newRec() {
		ICFIntTopProject rec =
			new CFIntBuffTopProject();
		return( rec );
	}

	public CFIntBuffTopProject ensureRec(ICFIntTopProject rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFIntBuffTopProject) {
			return( (CFIntBuffTopProject)rec );
		}
		else {
			CFIntBuffTopProject mapped = new CFIntBuffTopProject();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFIntTopProjectH newHRec() {
		ICFIntTopProjectH hrec =
			new CFIntBuffTopProjectH();
		return( hrec );
	}

	public CFIntBuffTopProjectH ensureHRec(ICFIntTopProjectH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFIntBuffTopProjectH) {
			return( (CFIntBuffTopProjectH)hrec );
		}
		else {
			CFIntBuffTopProjectH mapped = new CFIntBuffTopProjectH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
