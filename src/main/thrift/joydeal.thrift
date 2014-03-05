/**
 * Thrift interface for Joydeal
 *
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date Aug 13, 2013 8:12:29 PM
 */
namespace java com.joydeal.thrift

struct User {
    i64 id;
    string account;
    string name;
    byte gender;
    string email;
    string phone;
    string avatar;
    string password;
    string passtoken;
}

