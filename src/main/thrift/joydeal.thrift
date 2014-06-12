/**
 * Thrift interface for Joydeal
 *
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date Aug 13, 2013 8:12:29 PM
 */
namespace java com.joydeal.thrift

enum Gender {
    Men, Women, Unknown;
}

enum Status {
    Valid, Expired, Close;
}

struct User {
    1: required i64 id;
    2: required string account;
    3: required string name;
    4: optional string desc;
    5: optional Gender gender;
    6: required string email;
    7: required string phone;
    8: optional string avatar;
    9: required string password;
    10: required string passtoken;
}

struct Category {
    1: required string name;
    2: optional string desc;
    3: optional string parent;
    4: optional list<string> children;
}

struct Position {
    1: optional double lon;
    2: optional double lat;
    3: optional string name;
    4: optional string address;
}

struct Zone {
    1: required i64 id;
    2: required string name;
    3: required Category category;
    4: optional string desc;
    5: optional Position pos;
    6: required User lord;
    7: required User creator;
    8: optional string icon;
}

struct Good {
    1: required i64 id;
    2: required string name;
    3: required Category category;
    4: optional string desc;
    5: required User owner;
    6: optional User buyer;
    7: required Zone zone;
    8: optional i64 ttl;
    9: required double price;
    10: required Status status;
    11: optional string icon;
}

struct Need {
    1: required i64 id;
    2: required string name;
    3: required Category category;
    4: optional string desc;
    5: required User owner;
    6: optional User seller;
    7: required Zone zone;
    8: required i64 ttl;
    9: required double price;
    10: required Status status;
    11: optional string icon;
}

