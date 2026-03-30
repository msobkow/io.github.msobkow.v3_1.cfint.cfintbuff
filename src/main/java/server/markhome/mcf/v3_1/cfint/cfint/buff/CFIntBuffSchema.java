// Description: Java 25 buffer implementation of a CFInt schema.

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
import java.time.*;
import java.util.*;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.buff.*;

public class CFIntBuffSchema
	implements ICFIntSchema,
		ICFSecSchema
{

	protected ICFSecClusterTable tableCluster;
	protected ICFSecISOCcyTable tableISOCcy;
	protected ICFSecISOCtryTable tableISOCtry;
	protected ICFSecISOCtryCcyTable tableISOCtryCcy;
	protected ICFSecISOCtryLangTable tableISOCtryLang;
	protected ICFSecISOLangTable tableISOLang;
	protected ICFSecISOTZoneTable tableISOTZone;
	protected ICFIntLicenseTable tableLicense;
	protected ICFIntMajorVersionTable tableMajorVersion;
	protected ICFIntMimeTypeTable tableMimeType;
	protected ICFIntMinorVersionTable tableMinorVersion;
	protected ICFSecSecClusGrpTable tableSecClusGrp;
	protected ICFSecSecClusGrpIncTable tableSecClusGrpInc;
	protected ICFSecSecClusGrpMembTable tableSecClusGrpMemb;
	protected ICFSecSecSessionTable tableSecSession;
	protected ICFSecSecSysGrpTable tableSecSysGrp;
	protected ICFSecSecSysGrpIncTable tableSecSysGrpInc;
	protected ICFSecSecSysGrpMembTable tableSecSysGrpMemb;
	protected ICFSecSecTentGrpTable tableSecTentGrp;
	protected ICFSecSecTentGrpIncTable tableSecTentGrpInc;
	protected ICFSecSecTentGrpMembTable tableSecTentGrpMemb;
	protected ICFSecSecUserTable tableSecUser;
	protected ICFSecSecUserEMConfTable tableSecUserEMConf;
	protected ICFSecSecUserPWHistoryTable tableSecUserPWHistory;
	protected ICFSecSecUserPWResetTable tableSecUserPWReset;
	protected ICFSecSecUserPasswordTable tableSecUserPassword;
	protected ICFIntSubProjectTable tableSubProject;
	protected ICFSecSysClusterTable tableSysCluster;
	protected ICFSecTenantTable tableTenant;
	protected ICFIntTldTable tableTld;
	protected ICFIntTopDomainTable tableTopDomain;
	protected ICFIntTopProjectTable tableTopProject;
	protected ICFIntURLProtocolTable tableURLProtocol;

	protected ICFSecClusterFactory factoryCluster;
	protected ICFSecISOCcyFactory factoryISOCcy;
	protected ICFSecISOCtryFactory factoryISOCtry;
	protected ICFSecISOCtryCcyFactory factoryISOCtryCcy;
	protected ICFSecISOCtryLangFactory factoryISOCtryLang;
	protected ICFSecISOLangFactory factoryISOLang;
	protected ICFSecISOTZoneFactory factoryISOTZone;
	protected ICFIntLicenseFactory factoryLicense;
	protected ICFIntMajorVersionFactory factoryMajorVersion;
	protected ICFIntMimeTypeFactory factoryMimeType;
	protected ICFIntMinorVersionFactory factoryMinorVersion;
	protected ICFSecSecClusGrpFactory factorySecClusGrp;
	protected ICFSecSecClusGrpIncFactory factorySecClusGrpInc;
	protected ICFSecSecClusGrpMembFactory factorySecClusGrpMemb;
	protected ICFSecSecSessionFactory factorySecSession;
	protected ICFSecSecSysGrpFactory factorySecSysGrp;
	protected ICFSecSecSysGrpIncFactory factorySecSysGrpInc;
	protected ICFSecSecSysGrpMembFactory factorySecSysGrpMemb;
	protected ICFSecSecTentGrpFactory factorySecTentGrp;
	protected ICFSecSecTentGrpIncFactory factorySecTentGrpInc;
	protected ICFSecSecTentGrpMembFactory factorySecTentGrpMemb;
	protected ICFSecSecUserFactory factorySecUser;
	protected ICFSecSecUserEMConfFactory factorySecUserEMConf;
	protected ICFSecSecUserPWHistoryFactory factorySecUserPWHistory;
	protected ICFSecSecUserPWResetFactory factorySecUserPWReset;
	protected ICFSecSecUserPasswordFactory factorySecUserPassword;
	protected ICFIntSubProjectFactory factorySubProject;
	protected ICFSecSysClusterFactory factorySysCluster;
	protected ICFSecTenantFactory factoryTenant;
	protected ICFIntTldFactory factoryTld;
	protected ICFIntTopDomainFactory factoryTopDomain;
	protected ICFIntTopProjectFactory factoryTopProject;
	protected ICFIntURLProtocolFactory factoryURLProtocol;

	@Override
	public int initClassMapEntries(int value) {
		return( ICFIntSchema.doInitClassMapEntries(value) );
	}

	@Override
	public void wireRecConstructors() {
		ICFSecSchema.ClassMapEntry entry;
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntLicense.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntLicense ret = new CFIntBuffLicense();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntLicense.CLASS_CODE)[" + ICFIntLicense.CLASS_CODE + "]");
		}
	
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntMajorVersion.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntMajorVersion ret = new CFIntBuffMajorVersion();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntMajorVersion.CLASS_CODE)[" + ICFIntMajorVersion.CLASS_CODE + "]");
		}
	
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntMimeType.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntMimeType ret = new CFIntBuffMimeType();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntMimeType.CLASS_CODE)[" + ICFIntMimeType.CLASS_CODE + "]");
		}
	
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntMinorVersion.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntMinorVersion ret = new CFIntBuffMinorVersion();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntMinorVersion.CLASS_CODE)[" + ICFIntMinorVersion.CLASS_CODE + "]");
		}
	
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntSubProject.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntSubProject ret = new CFIntBuffSubProject();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntSubProject.CLASS_CODE)[" + ICFIntSubProject.CLASS_CODE + "]");
		}
	
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntTld.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntTld ret = new CFIntBuffTld();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntTld.CLASS_CODE)[" + ICFIntTld.CLASS_CODE + "]");
		}
	
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntTopDomain.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntTopDomain ret = new CFIntBuffTopDomain();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntTopDomain.CLASS_CODE)[" + ICFIntTopDomain.CLASS_CODE + "]");
		}
	
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntTopProject.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntTopProject ret = new CFIntBuffTopProject();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntTopProject.CLASS_CODE)[" + ICFIntTopProject.CLASS_CODE + "]");
		}
	
		entry = ICFIntSchema.getClassMapByBackingClassCode(ICFIntURLProtocol.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFIntURLProtocol ret = new CFIntBuffURLProtocol();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFIntBuffSchema.class, "wireRecConstructors", 0, "ICFIntSchema.getClassMapByBackingClassCode(ICFIntURLProtocol.CLASS_CODE)[" + ICFIntURLProtocol.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		throw new CFLibMustOverrideException(getClass(), "wireTableTableInstances");
	}

	@Override		
	public ICFSecSchema getCFSecSchema() {
		return( ICFSecSchema.getBackingCFSec() );
	}

	@Override
	public void setCFSecSchema(ICFSecSchema schema) {
		ICFSecSchema.setBackingCFSec(schema);
		schema.wireRecConstructors();
	}

	@Override		
	public ICFIntSchema getCFIntSchema() {
		return( ICFIntSchema.getBackingCFInt() );
	}

	@Override
	public void setCFIntSchema(ICFIntSchema schema) {
		ICFIntSchema.setBackingCFInt(schema);
		schema.wireRecConstructors();
	}

	public CFIntBuffSchema() {

	tableCluster = null; // new CFSecBuffClusterTable();
	tableISOCcy = null; // new CFSecBuffISOCcyTable();
	tableISOCtry = null; // new CFSecBuffISOCtryTable();
	tableISOCtryCcy = null; // new CFSecBuffISOCtryCcyTable();
	tableISOCtryLang = null; // new CFSecBuffISOCtryLangTable();
	tableISOLang = null; // new CFSecBuffISOLangTable();
	tableISOTZone = null; // new CFSecBuffISOTZoneTable();
	tableLicense = null; // new CFIntBuffLicenseTable();
	tableMajorVersion = null; // new CFIntBuffMajorVersionTable();
	tableMimeType = null; // new CFIntBuffMimeTypeTable();
	tableMinorVersion = null; // new CFIntBuffMinorVersionTable();
	tableSecClusGrp = null; // new CFSecBuffSecClusGrpTable();
	tableSecClusGrpInc = null; // new CFSecBuffSecClusGrpIncTable();
	tableSecClusGrpMemb = null; // new CFSecBuffSecClusGrpMembTable();
	tableSecSession = null; // new CFSecBuffSecSessionTable();
	tableSecSysGrp = null; // new CFSecBuffSecSysGrpTable();
	tableSecSysGrpInc = null; // new CFSecBuffSecSysGrpIncTable();
	tableSecSysGrpMemb = null; // new CFSecBuffSecSysGrpMembTable();
	tableSecTentGrp = null; // new CFSecBuffSecTentGrpTable();
	tableSecTentGrpInc = null; // new CFSecBuffSecTentGrpIncTable();
	tableSecTentGrpMemb = null; // new CFSecBuffSecTentGrpMembTable();
	tableSecUser = null; // new CFSecBuffSecUserTable();
	tableSecUserEMConf = null; // new CFSecBuffSecUserEMConfTable();
	tableSecUserPWHistory = null; // new CFSecBuffSecUserPWHistoryTable();
	tableSecUserPWReset = null; // new CFSecBuffSecUserPWResetTable();
	tableSecUserPassword = null; // new CFSecBuffSecUserPasswordTable();
	tableSubProject = null; // new CFIntBuffSubProjectTable();
	tableSysCluster = null; // new CFSecBuffSysClusterTable();
	tableTenant = null; // new CFSecBuffTenantTable();
	tableTld = null; // new CFIntBuffTldTable();
	tableTopDomain = null; // new CFIntBuffTopDomainTable();
	tableTopProject = null; // new CFIntBuffTopProjectTable();
	tableURLProtocol = null; // new CFIntBuffURLProtocolTable();

	factoryCluster = new CFSecBuffClusterDefaultFactory();
	factoryISOCcy = new CFSecBuffISOCcyDefaultFactory();
	factoryISOCtry = new CFSecBuffISOCtryDefaultFactory();
	factoryISOCtryCcy = new CFSecBuffISOCtryCcyDefaultFactory();
	factoryISOCtryLang = new CFSecBuffISOCtryLangDefaultFactory();
	factoryISOLang = new CFSecBuffISOLangDefaultFactory();
	factoryISOTZone = new CFSecBuffISOTZoneDefaultFactory();
	factoryLicense = new CFIntBuffLicenseDefaultFactory();
	factoryMajorVersion = new CFIntBuffMajorVersionDefaultFactory();
	factoryMimeType = new CFIntBuffMimeTypeDefaultFactory();
	factoryMinorVersion = new CFIntBuffMinorVersionDefaultFactory();
	factorySecClusGrp = new CFSecBuffSecClusGrpDefaultFactory();
	factorySecClusGrpInc = new CFSecBuffSecClusGrpIncDefaultFactory();
	factorySecClusGrpMemb = new CFSecBuffSecClusGrpMembDefaultFactory();
	factorySecSession = new CFSecBuffSecSessionDefaultFactory();
	factorySecSysGrp = new CFSecBuffSecSysGrpDefaultFactory();
	factorySecSysGrpInc = new CFSecBuffSecSysGrpIncDefaultFactory();
	factorySecSysGrpMemb = new CFSecBuffSecSysGrpMembDefaultFactory();
	factorySecTentGrp = new CFSecBuffSecTentGrpDefaultFactory();
	factorySecTentGrpInc = new CFSecBuffSecTentGrpIncDefaultFactory();
	factorySecTentGrpMemb = new CFSecBuffSecTentGrpMembDefaultFactory();
	factorySecUser = new CFSecBuffSecUserDefaultFactory();
	factorySecUserEMConf = new CFSecBuffSecUserEMConfDefaultFactory();
	factorySecUserPWHistory = new CFSecBuffSecUserPWHistoryDefaultFactory();
	factorySecUserPWReset = new CFSecBuffSecUserPWResetDefaultFactory();
	factorySecUserPassword = new CFSecBuffSecUserPasswordDefaultFactory();
	factorySubProject = new CFIntBuffSubProjectDefaultFactory();
	factorySysCluster = new CFSecBuffSysClusterDefaultFactory();
	factoryTenant = new CFSecBuffTenantDefaultFactory();
	factoryTld = new CFIntBuffTldDefaultFactory();
	factoryTopDomain = new CFIntBuffTopDomainDefaultFactory();
	factoryTopProject = new CFIntBuffTopProjectDefaultFactory();
	factoryURLProtocol = new CFIntBuffURLProtocolDefaultFactory();	}

	public ICFIntSchema newSchema() {
		throw new CFLibMustOverrideException( getClass(), "newSchema" );
	}

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOCcyIdGen");
	}

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOCtryIdGen");
	}

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOLangIdGen");
	}

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOTZoneIdGen");
	}

	/**
	 *	Get the next MimeTypeIdGen identifier.
	 *
	 *	@return	The next MimeTypeIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public int nextMimeTypeIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextMimeTypeIdGen");
	}

	/**
	 *	Get the next URLProtocolIdGen identifier.
	 *
	 *	@return	The next URLProtocolIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public int nextURLProtocolIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextURLProtocolIdGen");
	}

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextClusterIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSessionIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecUserIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTenantIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSysGrpIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecClusGrpIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecTentGrpIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next MajorVersionIdGen identifier.
	 *
	 *	@return	The next MajorVersionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextMajorVersionIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next MinorVersionIdGen identifier.
	 *
	 *	@return	The next MinorVersionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextMinorVersionIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SubProjectIdGen identifier.
	 *
	 *	@return	The next SubProjectIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSubProjectIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TldIdGen identifier.
	 *
	 *	@return	The next TldIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTldIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TopDomainIdGen identifier.
	 *
	 *	@return	The next TopDomainIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTopDomainIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TopProjectIdGen identifier.
	 *
	 *	@return	The next TopProjectIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTopProjectIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next LicenseIdGen identifier.
	 *
	 *	@return	The next LicenseIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextLicenseIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	public ICFSecClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ICFSecClusterTable value ) {
		tableCluster = value;
	}

	public ICFSecClusterFactory getFactoryCluster() {
		return( factoryCluster );
	}

	public void setFactoryCluster( ICFSecClusterFactory value ) {
		factoryCluster = value;
	}

	public ICFSecISOCcyTable getTableISOCcy() {
		return( tableISOCcy );
	}

	public void setTableISOCcy( ICFSecISOCcyTable value ) {
		tableISOCcy = value;
	}

	public ICFSecISOCcyFactory getFactoryISOCcy() {
		return( factoryISOCcy );
	}

	public void setFactoryISOCcy( ICFSecISOCcyFactory value ) {
		factoryISOCcy = value;
	}

	public ICFSecISOCtryTable getTableISOCtry() {
		return( tableISOCtry );
	}

	public void setTableISOCtry( ICFSecISOCtryTable value ) {
		tableISOCtry = value;
	}

	public ICFSecISOCtryFactory getFactoryISOCtry() {
		return( factoryISOCtry );
	}

	public void setFactoryISOCtry( ICFSecISOCtryFactory value ) {
		factoryISOCtry = value;
	}

	public ICFSecISOCtryCcyTable getTableISOCtryCcy() {
		return( tableISOCtryCcy );
	}

	public void setTableISOCtryCcy( ICFSecISOCtryCcyTable value ) {
		tableISOCtryCcy = value;
	}

	public ICFSecISOCtryCcyFactory getFactoryISOCtryCcy() {
		return( factoryISOCtryCcy );
	}

	public void setFactoryISOCtryCcy( ICFSecISOCtryCcyFactory value ) {
		factoryISOCtryCcy = value;
	}

	public ICFSecISOCtryLangTable getTableISOCtryLang() {
		return( tableISOCtryLang );
	}

	public void setTableISOCtryLang( ICFSecISOCtryLangTable value ) {
		tableISOCtryLang = value;
	}

	public ICFSecISOCtryLangFactory getFactoryISOCtryLang() {
		return( factoryISOCtryLang );
	}

	public void setFactoryISOCtryLang( ICFSecISOCtryLangFactory value ) {
		factoryISOCtryLang = value;
	}

	public ICFSecISOLangTable getTableISOLang() {
		return( tableISOLang );
	}

	public void setTableISOLang( ICFSecISOLangTable value ) {
		tableISOLang = value;
	}

	public ICFSecISOLangFactory getFactoryISOLang() {
		return( factoryISOLang );
	}

	public void setFactoryISOLang( ICFSecISOLangFactory value ) {
		factoryISOLang = value;
	}

	public ICFSecISOTZoneTable getTableISOTZone() {
		return( tableISOTZone );
	}

	public void setTableISOTZone( ICFSecISOTZoneTable value ) {
		tableISOTZone = value;
	}

	public ICFSecISOTZoneFactory getFactoryISOTZone() {
		return( factoryISOTZone );
	}

	public void setFactoryISOTZone( ICFSecISOTZoneFactory value ) {
		factoryISOTZone = value;
	}

	public ICFIntLicenseTable getTableLicense() {
		return( tableLicense );
	}

	public void setTableLicense( ICFIntLicenseTable value ) {
		tableLicense = value;
	}

	public ICFIntLicenseFactory getFactoryLicense() {
		return( factoryLicense );
	}

	public void setFactoryLicense( ICFIntLicenseFactory value ) {
		factoryLicense = value;
	}

	public ICFIntMajorVersionTable getTableMajorVersion() {
		return( tableMajorVersion );
	}

	public void setTableMajorVersion( ICFIntMajorVersionTable value ) {
		tableMajorVersion = value;
	}

	public ICFIntMajorVersionFactory getFactoryMajorVersion() {
		return( factoryMajorVersion );
	}

	public void setFactoryMajorVersion( ICFIntMajorVersionFactory value ) {
		factoryMajorVersion = value;
	}

	public ICFIntMimeTypeTable getTableMimeType() {
		return( tableMimeType );
	}

	public void setTableMimeType( ICFIntMimeTypeTable value ) {
		tableMimeType = value;
	}

	public ICFIntMimeTypeFactory getFactoryMimeType() {
		return( factoryMimeType );
	}

	public void setFactoryMimeType( ICFIntMimeTypeFactory value ) {
		factoryMimeType = value;
	}

	public ICFIntMinorVersionTable getTableMinorVersion() {
		return( tableMinorVersion );
	}

	public void setTableMinorVersion( ICFIntMinorVersionTable value ) {
		tableMinorVersion = value;
	}

	public ICFIntMinorVersionFactory getFactoryMinorVersion() {
		return( factoryMinorVersion );
	}

	public void setFactoryMinorVersion( ICFIntMinorVersionFactory value ) {
		factoryMinorVersion = value;
	}

	public ICFSecSecClusGrpTable getTableSecClusGrp() {
		return( tableSecClusGrp );
	}

	public void setTableSecClusGrp( ICFSecSecClusGrpTable value ) {
		tableSecClusGrp = value;
	}

	public ICFSecSecClusGrpFactory getFactorySecClusGrp() {
		return( factorySecClusGrp );
	}

	public void setFactorySecClusGrp( ICFSecSecClusGrpFactory value ) {
		factorySecClusGrp = value;
	}

	public ICFSecSecClusGrpIncTable getTableSecClusGrpInc() {
		return( tableSecClusGrpInc );
	}

	public void setTableSecClusGrpInc( ICFSecSecClusGrpIncTable value ) {
		tableSecClusGrpInc = value;
	}

	public ICFSecSecClusGrpIncFactory getFactorySecClusGrpInc() {
		return( factorySecClusGrpInc );
	}

	public void setFactorySecClusGrpInc( ICFSecSecClusGrpIncFactory value ) {
		factorySecClusGrpInc = value;
	}

	public ICFSecSecClusGrpMembTable getTableSecClusGrpMemb() {
		return( tableSecClusGrpMemb );
	}

	public void setTableSecClusGrpMemb( ICFSecSecClusGrpMembTable value ) {
		tableSecClusGrpMemb = value;
	}

	public ICFSecSecClusGrpMembFactory getFactorySecClusGrpMemb() {
		return( factorySecClusGrpMemb );
	}

	public void setFactorySecClusGrpMemb( ICFSecSecClusGrpMembFactory value ) {
		factorySecClusGrpMemb = value;
	}

	public ICFSecSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ICFSecSecSessionTable value ) {
		tableSecSession = value;
	}

	public ICFSecSecSessionFactory getFactorySecSession() {
		return( factorySecSession );
	}

	public void setFactorySecSession( ICFSecSecSessionFactory value ) {
		factorySecSession = value;
	}

	public ICFSecSecSysGrpTable getTableSecSysGrp() {
		return( tableSecSysGrp );
	}

	public void setTableSecSysGrp( ICFSecSecSysGrpTable value ) {
		tableSecSysGrp = value;
	}

	public ICFSecSecSysGrpFactory getFactorySecSysGrp() {
		return( factorySecSysGrp );
	}

	public void setFactorySecSysGrp( ICFSecSecSysGrpFactory value ) {
		factorySecSysGrp = value;
	}

	public ICFSecSecSysGrpIncTable getTableSecSysGrpInc() {
		return( tableSecSysGrpInc );
	}

	public void setTableSecSysGrpInc( ICFSecSecSysGrpIncTable value ) {
		tableSecSysGrpInc = value;
	}

	public ICFSecSecSysGrpIncFactory getFactorySecSysGrpInc() {
		return( factorySecSysGrpInc );
	}

	public void setFactorySecSysGrpInc( ICFSecSecSysGrpIncFactory value ) {
		factorySecSysGrpInc = value;
	}

	public ICFSecSecSysGrpMembTable getTableSecSysGrpMemb() {
		return( tableSecSysGrpMemb );
	}

	public void setTableSecSysGrpMemb( ICFSecSecSysGrpMembTable value ) {
		tableSecSysGrpMemb = value;
	}

	public ICFSecSecSysGrpMembFactory getFactorySecSysGrpMemb() {
		return( factorySecSysGrpMemb );
	}

	public void setFactorySecSysGrpMemb( ICFSecSecSysGrpMembFactory value ) {
		factorySecSysGrpMemb = value;
	}

	public ICFSecSecTentGrpTable getTableSecTentGrp() {
		return( tableSecTentGrp );
	}

	public void setTableSecTentGrp( ICFSecSecTentGrpTable value ) {
		tableSecTentGrp = value;
	}

	public ICFSecSecTentGrpFactory getFactorySecTentGrp() {
		return( factorySecTentGrp );
	}

	public void setFactorySecTentGrp( ICFSecSecTentGrpFactory value ) {
		factorySecTentGrp = value;
	}

	public ICFSecSecTentGrpIncTable getTableSecTentGrpInc() {
		return( tableSecTentGrpInc );
	}

	public void setTableSecTentGrpInc( ICFSecSecTentGrpIncTable value ) {
		tableSecTentGrpInc = value;
	}

	public ICFSecSecTentGrpIncFactory getFactorySecTentGrpInc() {
		return( factorySecTentGrpInc );
	}

	public void setFactorySecTentGrpInc( ICFSecSecTentGrpIncFactory value ) {
		factorySecTentGrpInc = value;
	}

	public ICFSecSecTentGrpMembTable getTableSecTentGrpMemb() {
		return( tableSecTentGrpMemb );
	}

	public void setTableSecTentGrpMemb( ICFSecSecTentGrpMembTable value ) {
		tableSecTentGrpMemb = value;
	}

	public ICFSecSecTentGrpMembFactory getFactorySecTentGrpMemb() {
		return( factorySecTentGrpMemb );
	}

	public void setFactorySecTentGrpMemb( ICFSecSecTentGrpMembFactory value ) {
		factorySecTentGrpMemb = value;
	}

	public ICFSecSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ICFSecSecUserTable value ) {
		tableSecUser = value;
	}

	public ICFSecSecUserFactory getFactorySecUser() {
		return( factorySecUser );
	}

	public void setFactorySecUser( ICFSecSecUserFactory value ) {
		factorySecUser = value;
	}

	public ICFSecSecUserEMConfTable getTableSecUserEMConf() {
		return( tableSecUserEMConf );
	}

	public void setTableSecUserEMConf( ICFSecSecUserEMConfTable value ) {
		tableSecUserEMConf = value;
	}

	public ICFSecSecUserEMConfFactory getFactorySecUserEMConf() {
		return( factorySecUserEMConf );
	}

	public void setFactorySecUserEMConf( ICFSecSecUserEMConfFactory value ) {
		factorySecUserEMConf = value;
	}

	public ICFSecSecUserPWHistoryTable getTableSecUserPWHistory() {
		return( tableSecUserPWHistory );
	}

	public void setTableSecUserPWHistory( ICFSecSecUserPWHistoryTable value ) {
		tableSecUserPWHistory = value;
	}

	public ICFSecSecUserPWHistoryFactory getFactorySecUserPWHistory() {
		return( factorySecUserPWHistory );
	}

	public void setFactorySecUserPWHistory( ICFSecSecUserPWHistoryFactory value ) {
		factorySecUserPWHistory = value;
	}

	public ICFSecSecUserPWResetTable getTableSecUserPWReset() {
		return( tableSecUserPWReset );
	}

	public void setTableSecUserPWReset( ICFSecSecUserPWResetTable value ) {
		tableSecUserPWReset = value;
	}

	public ICFSecSecUserPWResetFactory getFactorySecUserPWReset() {
		return( factorySecUserPWReset );
	}

	public void setFactorySecUserPWReset( ICFSecSecUserPWResetFactory value ) {
		factorySecUserPWReset = value;
	}

	public ICFSecSecUserPasswordTable getTableSecUserPassword() {
		return( tableSecUserPassword );
	}

	public void setTableSecUserPassword( ICFSecSecUserPasswordTable value ) {
		tableSecUserPassword = value;
	}

	public ICFSecSecUserPasswordFactory getFactorySecUserPassword() {
		return( factorySecUserPassword );
	}

	public void setFactorySecUserPassword( ICFSecSecUserPasswordFactory value ) {
		factorySecUserPassword = value;
	}

	public ICFIntSubProjectTable getTableSubProject() {
		return( tableSubProject );
	}

	public void setTableSubProject( ICFIntSubProjectTable value ) {
		tableSubProject = value;
	}

	public ICFIntSubProjectFactory getFactorySubProject() {
		return( factorySubProject );
	}

	public void setFactorySubProject( ICFIntSubProjectFactory value ) {
		factorySubProject = value;
	}

	public ICFSecSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ICFSecSysClusterTable value ) {
		tableSysCluster = value;
	}

	public ICFSecSysClusterFactory getFactorySysCluster() {
		return( factorySysCluster );
	}

	public void setFactorySysCluster( ICFSecSysClusterFactory value ) {
		factorySysCluster = value;
	}

	public ICFSecTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ICFSecTenantTable value ) {
		tableTenant = value;
	}

	public ICFSecTenantFactory getFactoryTenant() {
		return( factoryTenant );
	}

	public void setFactoryTenant( ICFSecTenantFactory value ) {
		factoryTenant = value;
	}

	public ICFIntTldTable getTableTld() {
		return( tableTld );
	}

	public void setTableTld( ICFIntTldTable value ) {
		tableTld = value;
	}

	public ICFIntTldFactory getFactoryTld() {
		return( factoryTld );
	}

	public void setFactoryTld( ICFIntTldFactory value ) {
		factoryTld = value;
	}

	public ICFIntTopDomainTable getTableTopDomain() {
		return( tableTopDomain );
	}

	public void setTableTopDomain( ICFIntTopDomainTable value ) {
		tableTopDomain = value;
	}

	public ICFIntTopDomainFactory getFactoryTopDomain() {
		return( factoryTopDomain );
	}

	public void setFactoryTopDomain( ICFIntTopDomainFactory value ) {
		factoryTopDomain = value;
	}

	public ICFIntTopProjectTable getTableTopProject() {
		return( tableTopProject );
	}

	public void setTableTopProject( ICFIntTopProjectTable value ) {
		tableTopProject = value;
	}

	public ICFIntTopProjectFactory getFactoryTopProject() {
		return( factoryTopProject );
	}

	public void setFactoryTopProject( ICFIntTopProjectFactory value ) {
		factoryTopProject = value;
	}

	public ICFIntURLProtocolTable getTableURLProtocol() {
		return( tableURLProtocol );
	}

	public void setTableURLProtocol( ICFIntURLProtocolTable value ) {
		tableURLProtocol = value;
	}

	public ICFIntURLProtocolFactory getFactoryURLProtocol() {
		return( factoryURLProtocol );
	}

	public void setFactoryURLProtocol( ICFIntURLProtocolFactory value ) {
		factoryURLProtocol = value;
	}

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public static ICFSecTablePerms getTablePerms() {
		return(CFSecBuffSchema.getTablePerms());
	}

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	public static ICFIntTablePerms getCFIntTablePerms() {
		return (ICFIntTablePerms)getTablePerms();
	}

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ICFSecTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public static void setTablePerms( ICFSecTablePerms value ) {
		CFSecBuffSchema.setTablePerms(value);
	}

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}

	public void bootstrapSchema() {
	}
}
