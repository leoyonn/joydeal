/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.joydeal.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Position implements org.apache.thrift.TBase<Position, Position._Fields>, java.io.Serializable, Cloneable, Comparable<Position> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Position");

  private static final org.apache.thrift.protocol.TField LON_FIELD_DESC = new org.apache.thrift.protocol.TField("lon", org.apache.thrift.protocol.TType.DOUBLE, (short)1);
  private static final org.apache.thrift.protocol.TField LAT_FIELD_DESC = new org.apache.thrift.protocol.TField("lat", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("address", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PositionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PositionTupleSchemeFactory());
  }

  public double lon; // optional
  public double lat; // optional
  public String name; // optional
  public String address; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    LON((short)1, "lon"),
    LAT((short)2, "lat"),
    NAME((short)3, "name"),
    ADDRESS((short)4, "address");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // LON
          return LON;
        case 2: // LAT
          return LAT;
        case 3: // NAME
          return NAME;
        case 4: // ADDRESS
          return ADDRESS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __LON_ISSET_ID = 0;
  private static final int __LAT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.LON,_Fields.LAT,_Fields.NAME,_Fields.ADDRESS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LON, new org.apache.thrift.meta_data.FieldMetaData("lon", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.LAT, new org.apache.thrift.meta_data.FieldMetaData("lat", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("address", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Position.class, metaDataMap);
  }

  public Position() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Position(Position other) {
    __isset_bitfield = other.__isset_bitfield;
    this.lon = other.lon;
    this.lat = other.lat;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetAddress()) {
      this.address = other.address;
    }
  }

  public Position deepCopy() {
    return new Position(this);
  }

  @Override
  public void clear() {
    setLonIsSet(false);
    this.lon = 0.0;
    setLatIsSet(false);
    this.lat = 0.0;
    this.name = null;
    this.address = null;
  }

  public double getLon() {
    return this.lon;
  }

  public Position setLon(double lon) {
    this.lon = lon;
    setLonIsSet(true);
    return this;
  }

  public void unsetLon() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LON_ISSET_ID);
  }

  /** Returns true if field lon is set (has been assigned a value) and false otherwise */
  public boolean isSetLon() {
    return EncodingUtils.testBit(__isset_bitfield, __LON_ISSET_ID);
  }

  public void setLonIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LON_ISSET_ID, value);
  }

  public double getLat() {
    return this.lat;
  }

  public Position setLat(double lat) {
    this.lat = lat;
    setLatIsSet(true);
    return this;
  }

  public void unsetLat() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LAT_ISSET_ID);
  }

  /** Returns true if field lat is set (has been assigned a value) and false otherwise */
  public boolean isSetLat() {
    return EncodingUtils.testBit(__isset_bitfield, __LAT_ISSET_ID);
  }

  public void setLatIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LAT_ISSET_ID, value);
  }

  public String getName() {
    return this.name;
  }

  public Position setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getAddress() {
    return this.address;
  }

  public Position setAddress(String address) {
    this.address = address;
    return this;
  }

  public void unsetAddress() {
    this.address = null;
  }

  /** Returns true if field address is set (has been assigned a value) and false otherwise */
  public boolean isSetAddress() {
    return this.address != null;
  }

  public void setAddressIsSet(boolean value) {
    if (!value) {
      this.address = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LON:
      if (value == null) {
        unsetLon();
      } else {
        setLon((Double)value);
      }
      break;

    case LAT:
      if (value == null) {
        unsetLat();
      } else {
        setLat((Double)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case ADDRESS:
      if (value == null) {
        unsetAddress();
      } else {
        setAddress((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LON:
      return Double.valueOf(getLon());

    case LAT:
      return Double.valueOf(getLat());

    case NAME:
      return getName();

    case ADDRESS:
      return getAddress();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LON:
      return isSetLon();
    case LAT:
      return isSetLat();
    case NAME:
      return isSetName();
    case ADDRESS:
      return isSetAddress();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Position)
      return this.equals((Position)that);
    return false;
  }

  public boolean equals(Position that) {
    if (that == null)
      return false;

    boolean this_present_lon = true && this.isSetLon();
    boolean that_present_lon = true && that.isSetLon();
    if (this_present_lon || that_present_lon) {
      if (!(this_present_lon && that_present_lon))
        return false;
      if (this.lon != that.lon)
        return false;
    }

    boolean this_present_lat = true && this.isSetLat();
    boolean that_present_lat = true && that.isSetLat();
    if (this_present_lat || that_present_lat) {
      if (!(this_present_lat && that_present_lat))
        return false;
      if (this.lat != that.lat)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_address = true && this.isSetAddress();
    boolean that_present_address = true && that.isSetAddress();
    if (this_present_address || that_present_address) {
      if (!(this_present_address && that_present_address))
        return false;
      if (!this.address.equals(that.address))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Position other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetLon()).compareTo(other.isSetLon());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLon()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lon, other.lon);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLat()).compareTo(other.isSetLat());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLat()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lat, other.lat);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAddress()).compareTo(other.isSetAddress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAddress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.address, other.address);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Position(");
    boolean first = true;

    if (isSetLon()) {
      sb.append("lon:");
      sb.append(this.lon);
      first = false;
    }
    if (isSetLat()) {
      if (!first) sb.append(", ");
      sb.append("lat:");
      sb.append(this.lat);
      first = false;
    }
    if (isSetName()) {
      if (!first) sb.append(", ");
      sb.append("name:");
      if (this.name == null) {
        sb.append("null");
      } else {
        sb.append(this.name);
      }
      first = false;
    }
    if (isSetAddress()) {
      if (!first) sb.append(", ");
      sb.append("address:");
      if (this.address == null) {
        sb.append("null");
      } else {
        sb.append(this.address);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PositionStandardSchemeFactory implements SchemeFactory {
    public PositionStandardScheme getScheme() {
      return new PositionStandardScheme();
    }
  }

  private static class PositionStandardScheme extends StandardScheme<Position> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Position struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // LON
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.lon = iprot.readDouble();
              struct.setLonIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LAT
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.lat = iprot.readDouble();
              struct.setLatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ADDRESS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.address = iprot.readString();
              struct.setAddressIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Position struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetLon()) {
        oprot.writeFieldBegin(LON_FIELD_DESC);
        oprot.writeDouble(struct.lon);
        oprot.writeFieldEnd();
      }
      if (struct.isSetLat()) {
        oprot.writeFieldBegin(LAT_FIELD_DESC);
        oprot.writeDouble(struct.lat);
        oprot.writeFieldEnd();
      }
      if (struct.name != null) {
        if (struct.isSetName()) {
          oprot.writeFieldBegin(NAME_FIELD_DESC);
          oprot.writeString(struct.name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.address != null) {
        if (struct.isSetAddress()) {
          oprot.writeFieldBegin(ADDRESS_FIELD_DESC);
          oprot.writeString(struct.address);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PositionTupleSchemeFactory implements SchemeFactory {
    public PositionTupleScheme getScheme() {
      return new PositionTupleScheme();
    }
  }

  private static class PositionTupleScheme extends TupleScheme<Position> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Position struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetLon()) {
        optionals.set(0);
      }
      if (struct.isSetLat()) {
        optionals.set(1);
      }
      if (struct.isSetName()) {
        optionals.set(2);
      }
      if (struct.isSetAddress()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetLon()) {
        oprot.writeDouble(struct.lon);
      }
      if (struct.isSetLat()) {
        oprot.writeDouble(struct.lat);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetAddress()) {
        oprot.writeString(struct.address);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Position struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.lon = iprot.readDouble();
        struct.setLonIsSet(true);
      }
      if (incoming.get(1)) {
        struct.lat = iprot.readDouble();
        struct.setLatIsSet(true);
      }
      if (incoming.get(2)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.address = iprot.readString();
        struct.setAddressIsSet(true);
      }
    }
  }

}

