// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: order.proto

package com.andrew.messagedefinition;

public interface OrderOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.andrew.messagedefinition.Order)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string itemId = 1;</code>
   * @return The itemId.
   */
  java.lang.String getItemId();
  /**
   * <code>string itemId = 1;</code>
   * @return The bytes for itemId.
   */
  com.google.protobuf.ByteString
      getItemIdBytes();

  /**
   * <code>int64 quantity = 2;</code>
   * @return The quantity.
   */
  long getQuantity();

  /**
   * <code>.com.andrew.messagedefinition.Address shippingAddress = 3;</code>
   * @return Whether the shippingAddress field is set.
   */
  boolean hasShippingAddress();
  /**
   * <code>.com.andrew.messagedefinition.Address shippingAddress = 3;</code>
   * @return The shippingAddress.
   */
  com.andrew.messagedefinition.Address getShippingAddress();
  /**
   * <code>.com.andrew.messagedefinition.Address shippingAddress = 3;</code>
   */
  com.andrew.messagedefinition.AddressOrBuilder getShippingAddressOrBuilder();
}
