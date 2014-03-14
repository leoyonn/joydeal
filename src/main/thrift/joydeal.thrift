/**
 * Thrift interface for Joydeal
 *
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date Aug 13, 2013 8:12:29 PM
 */
namespace java com.joydeal.thrift

enum Gender {
    Men, Women;
}

enum Status {
    Valid, Expired, Close;
}

struct User {
    1:  i64 id;
    2:  string account;
    3:  string name;
    4:  Gender gender;
    5:  string email;
    6:  string phone;
    7:  string avatar;
    8:  string password;
    9:  string passtoken;
}

struct Category {
    1:  i16 id;
    2:  string name;
    3:  string desc;
    4:  i16 parent;
    5:  list<i16> children;
}

struct Position {
    1:  double lon;
    2:  double lat;
    3:  string name;
    4:  string address;
}

struct Zone {
    1:  i64 id;
    2:  string name;
    3:  Category category;
    4:  string desc;
    5:  Position pos;
    6:  User lord;
    7:  User creator;
}

struct Good {
    1:  i64 id;
    2:  string name;
    3:  Category category;
    4:  string desc;
    5:  User owner;
    6:  User buyer;
    7:  Zone zone;
    8:  i64 ttl;
    9:  double price;
    10: Status status;
    11: string icon;
}

struct Need {
    1:  i64 id;
    2:  string name;
    3:  Category category;
    4:  string desc;
    5:  User owner;
    6:  User seller;
    7:  Zone zone;
    8:  i64 ttl;
    9:  double price;
    10: Status status;
    11: string icon;
}

