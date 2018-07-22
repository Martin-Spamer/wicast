<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified">
  <xs:element name="wicast">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="client"/>
        <xs:element ref="server"/>
        <xs:element ref="relay"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="client">
    <xs:complexType>
      <xs:sequence>
        <xs:element maxOccurs="unbounded" ref="source"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="server">
    <xs:complexType>
      <xs:sequence>
        <xs:element maxOccurs="unbounded" ref="channel"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="channel">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="data"/>
      </xs:sequence>
      <xs:attribute name="id" use="required"/>
      <xs:attribute name="ip" use="required"/>
      <xs:attribute name="name" use="required"/>
      <xs:attribute name="port" use="required"/>
    </xs:complexType>
  </xs:element>
  <xs:element name="data">
    <xs:complexType/>
  </xs:element>
  <xs:element name="relay">
    <xs:complexType>
      <xs:sequence>
        <xs:element maxOccurs="unbounded" ref="source"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  <xs:element name="source">
    <xs:complexType>
      <xs:sequence>
        <xs:element minOccurs="0" ref="destination"/>
      </xs:sequence>
      <xs:attribute name="address" type="xs:NCName"/>
      <xs:attribute name="id" use="required"/>
      <xs:attribute name="ip" use="required"/>
      <xs:attribute name="name" use="required"/>
      <xs:attribute name="port" use="required"/>
    </xs:complexType>
  </xs:element>
  <xs:element name="destination">
    <xs:complexType>
      <xs:attribute name="id" use="required"/>
      <xs:attribute name="ip" use="required"/>
      <xs:attribute name="name" use="required"/>
      <xs:attribute name="port" use="required"/>
    </xs:complexType>
  </xs:element>
</xs:schema>
