/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.joydeal.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum Gender implements org.apache.thrift.TEnum {
  Man(0),
  Woman(1),
  Unknown(2);

  private final int value;

  private Gender(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Gender findByValue(int value) { 
    switch (value) {
      case 0:
        return Man;
      case 1:
        return Woman;
      case 2:
        return Unknown;
      default:
        return null;
    }
  }
}
