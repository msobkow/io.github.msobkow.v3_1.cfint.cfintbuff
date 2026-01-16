// Description: Java 25 implementation of a TopDomain buffer

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
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cflib.xml.CFLibXmlUtil;
import io.github.msobkow.v3_1.cfsec.cfsec.*;
import io.github.msobkow.v3_1.cfint.cfint.*;
import io.github.msobkow.v3_1.cfsec.cfsec.buff.*;

public class CFIntBuffTopDomain
	implements ICFIntTopDomain, Comparable<Object>, Serializable
{
	protected CFLibDbKeyHash256 requiredId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFIntTopDomain.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFIntTopDomain.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 requiredTenantId;
	protected CFLibDbKeyHash256 requiredTldId;
	protected String requiredName;
	protected String optionalDescription;

	public CFIntBuffTopDomain() {
		requiredId = CFLibDbKeyHash256.fromHex( ICFIntTopDomain.ID_INIT_VALUE.toString() );
		requiredTenantId = CFLibDbKeyHash256.fromHex( ICFIntTopDomain.TENANTID_INIT_VALUE.toString() );
		requiredTldId = CFLibDbKeyHash256.fromHex( ICFIntTopDomain.TLDID_INIT_VALUE.toString() );
		requiredName = ICFIntTopDomain.NAME_INIT_VALUE;
		optionalDescription = null;
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return getRequiredId();
	}

	@Override
	public void setPKey(CFLibDbKeyHash256 requiredId) {
		if (requiredId != null) {
			setRequiredId(requiredId);
		}
	}

	@Override
	public CFLibDbKeyHash256 getRequiredId() {
		return( requiredId );
	}

	@Override
	public void setRequiredId( CFLibDbKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredId",
				1,
				"value" );
		}
		requiredId = value;
	}

	@Override
	public CFLibDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public CFLibDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		updatedAt = value;
	}
	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( ICFIntTopDomain.CLASS_CODE );
	}

	@Override
	public List<ICFIntTopProject> getOptionalComponentsTopProject() {
		ICFIntSchema targetBackingSchema = ICFIntSchema.getBackingCFInt();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsTopProject", 0, "ICFIntSchema.getBackingCFInt()");
		}
		ICFIntTopProjectTable targetTable = targetBackingSchema.getTableTopProject();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsTopProject", 0, "ICFIntSchema.getBackingCFInt().getTableTopProject()");
		}
		ICFIntTopProject[] targetArr = targetTable.readDerivedByTopDomainIdx(null, getRequiredId());
		if( targetArr != null ) {
			List<ICFIntTopProject> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFIntTopProject> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public List<ICFIntLicense> getOptionalComponentsLicense() {
		ICFIntSchema targetBackingSchema = ICFIntSchema.getBackingCFInt();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsLicense", 0, "ICFIntSchema.getBackingCFInt()");
		}
		ICFIntLicenseTable targetTable = targetBackingSchema.getTableLicense();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsLicense", 0, "ICFIntSchema.getBackingCFInt().getTableLicense()");
		}
		ICFIntLicense[] targetArr = targetTable.readDerivedByDomainIdx(null, getRequiredId());
		if( targetArr != null ) {
			List<ICFIntLicense> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFIntLicense> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public ICFSecTenant getRequiredOwnerTenant() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecTenantTable targetTable = targetBackingSchema.getTableTenant();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecSchema.getBackingCFSec().getTableTenant()");
		}
		ICFSecTenant targetRec = targetTable.readDerived(null, getRequiredTenantId());
		return(targetRec);
	}
	@Override
	public void setRequiredOwnerTenant(ICFSecTenant argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			requiredTenantId = argObj.getRequiredId();
		}
	}

	@Override
	public void setRequiredOwnerTenant(CFLibDbKeyHash256 argTenantId) {
		requiredTenantId = argTenantId;
	}

	@Override
	public ICFIntTld getRequiredContainerParentTld() {
		ICFIntSchema targetBackingSchema = ICFIntSchema.getBackingCFInt();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerParentTld", 0, "ICFIntSchema.getBackingCFInt()");
		}
		ICFIntTldTable targetTable = targetBackingSchema.getTableTld();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerParentTld", 0, "ICFIntSchema.getBackingCFInt().getTableTld()");
		}
		ICFIntTld targetRec = targetTable.readDerived(null, getRequiredTldId());
		return(targetRec);
	}
	@Override
	public void setRequiredContainerParentTld(ICFIntTld argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setContainerParentTld", 1, "argObj");
		}
		else {
			requiredTldId = argObj.getRequiredId();
		}
	}

	@Override
	public void setRequiredContainerParentTld(CFLibDbKeyHash256 argTldId) {
		requiredTldId = argTldId;
	}

	@Override
	public CFLibDbKeyHash256 getRequiredTenantId() {
		return( requiredTenantId );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredTldId() {
		return( requiredTldId );
	}

	@Override
	public String getRequiredName() {
		return( requiredName );
	}

	@Override
	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredName = value;
	}

	@Override
	public String getOptionalDescription() {
		return( optionalDescription );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( value != null && value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		optionalDescription = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFIntTopDomain ) {
			ICFIntTopDomain rhs = (ICFIntTopDomain)obj;
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredId() != null && !getRequiredId().isNull() ) {
				if( rhs.getRequiredId() != null && !rhs.getRequiredId().isNull() ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null && !getRequiredId().isNull()) {
					return( false );
				}
			}
			if( getRequiredTenantId() != null && !getRequiredTenantId().isNull() ) {
				if( rhs.getRequiredTenantId() != null && !rhs.getRequiredTenantId().isNull() ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null && !getRequiredTenantId().isNull()) {
					return( false );
				}
			}
			if( getRequiredTldId() != null && !getRequiredTldId().isNull() ) {
				if( rhs.getRequiredTldId() != null && !rhs.getRequiredTldId().isNull() ) {
					if( ! getRequiredTldId().equals( rhs.getRequiredTldId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTldId() != null && !getRequiredTldId().isNull()) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFIntTopDomainH ) {
			ICFIntTopDomainH rhs = (ICFIntTopDomainH)obj;
			if( getRequiredId() != null && !getRequiredId().isNull() ) {
				if( rhs.getRequiredId() != null && !rhs.getRequiredId().isNull() ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null && !getRequiredId().isNull()) {
					return( false );
				}
			}
			if( getRequiredTenantId() != null && !getRequiredTenantId().isNull() ) {
				if( rhs.getRequiredTenantId() != null && !rhs.getRequiredTenantId().isNull() ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null && !getRequiredTenantId().isNull()) {
					return( false );
				}
			}
			if( getRequiredTldId() != null && !getRequiredTldId().isNull() ) {
				if( rhs.getRequiredTldId() != null && !rhs.getRequiredTldId().isNull() ) {
					if( ! getRequiredTldId().equals( rhs.getRequiredTldId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTldId() != null && !getRequiredTldId().isNull()) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFIntTopDomainHPKey ) {
			ICFIntTopDomainHPKey rhs = (ICFIntTopDomainHPKey)obj;
			if( getRequiredId() != null && !getRequiredId().isNull() ) {
				if( rhs.getRequiredId() != null && !rhs.getRequiredId().isNull() ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null && !getRequiredId().isNull()) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFIntTopDomainByTenantIdxKey ) {
			ICFIntTopDomainByTenantIdxKey rhs = (ICFIntTopDomainByTenantIdxKey)obj;
			if( getRequiredTenantId() != null && !getRequiredTenantId().isNull() ) {
				if( rhs.getRequiredTenantId() != null && !rhs.getRequiredTenantId().isNull() ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null && !getRequiredTenantId().isNull()) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFIntTopDomainByTldIdxKey ) {
			ICFIntTopDomainByTldIdxKey rhs = (ICFIntTopDomainByTldIdxKey)obj;
			if( getRequiredTldId() != null && !getRequiredTldId().isNull() ) {
				if( rhs.getRequiredTldId() != null && !rhs.getRequiredTldId().isNull() ) {
					if( ! getRequiredTldId().equals( rhs.getRequiredTldId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTldId() != null && !getRequiredTldId().isNull()) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFIntTopDomainByNameIdxKey ) {
			ICFIntTopDomainByNameIdxKey rhs = (ICFIntTopDomainByNameIdxKey)obj;
			if( getRequiredTldId() != null && !getRequiredTldId().isNull() ) {
				if( rhs.getRequiredTldId() != null && !rhs.getRequiredTldId().isNull() ) {
					if( ! getRequiredTldId().equals( rhs.getRequiredTldId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTldId() != null && !getRequiredTldId().isNull()) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + getRequiredId().hashCode();
		hashCode = hashCode + getRequiredTenantId().hashCode();
		hashCode = hashCode + getRequiredTldId().hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFIntTopDomain ) {
			ICFIntTopDomain rhs = (ICFIntTopDomain)obj;
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTldId() != null) {
				if (rhs.getRequiredTldId() != null) {
					cmp = getRequiredTldId().compareTo( rhs.getRequiredTldId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTldId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFIntTopDomainHPKey ) {
			ICFIntTopDomainHPKey rhs = (ICFIntTopDomainHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFIntTopDomainH ) {
			ICFIntTopDomainH rhs = (ICFIntTopDomainH)obj;
			cmp = 0;
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTldId() != null) {
				if (rhs.getRequiredTldId() != null) {
					cmp = getRequiredTldId().compareTo( rhs.getRequiredTldId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTldId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFIntTopDomainByTenantIdxKey ) {
			ICFIntTopDomainByTenantIdxKey rhs = (ICFIntTopDomainByTenantIdxKey)obj;

			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFIntTopDomainByTldIdxKey ) {
			ICFIntTopDomainByTldIdxKey rhs = (ICFIntTopDomainByTldIdxKey)obj;

			if (getRequiredTldId() != null) {
				if (rhs.getRequiredTldId() != null) {
					cmp = getRequiredTldId().compareTo( rhs.getRequiredTldId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTldId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFIntTopDomainByNameIdxKey ) {
			ICFIntTopDomainByNameIdxKey rhs = (ICFIntTopDomainByNameIdxKey)obj;

			if (getRequiredTldId() != null) {
				if (rhs.getRequiredTldId() != null) {
					cmp = getRequiredTldId().compareTo( rhs.getRequiredTldId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTldId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( ICFIntTopDomain src ) {
		setTopDomain( src );
	}

	@Override
	public void setTopDomain( ICFIntTopDomain src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredOwnerTenant(src.getRequiredTenantId());
		setRequiredContainerParentTld(src.getRequiredContainerParentTld());
		setRequiredName(src.getRequiredName());
		setOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public void set( ICFIntTopDomainH src ) {
		setTopDomain( src );
	}

	@Override
	public void setTopDomain( ICFIntTopDomainH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredOwnerTenant(src.getRequiredTenantId());
		setRequiredContainerParentTld(src.getRequiredTldId());
		setRequiredName(src.getRequiredName());
		setOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredTenantId=" + "\"" + getRequiredTenantId().toString() + "\""
			+ " RequiredTldId=" + "\"" + getRequiredTldId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " OptionalDescription=" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFIntBuffTopDomain" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
