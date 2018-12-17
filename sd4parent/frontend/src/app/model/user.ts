import {Role} from "./role";
import {BillingAccount} from "./billing-account";
import {Purse} from "./purse";

export class User {
  id: string;
  login: string;
  password: string;
  role: string
  account: BillingAccount;
  purse: Purse;

  static cloneBase(user: User): User {
    let clonedUser: User = new User();
    clonedUser.id = user.id;
    clonedUser.login = user.login;
    clonedUser.password = user.password;
    clonedUser.role = user.role;
    return clonedUser;
  }
}
