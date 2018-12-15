import {Role} from "./role";

export class UserAccount {
  accountId: number;
  login: string;
  password: string;
  email: string;
  role: Role;
  firstName: string;
  lastName: string;

  static cloneAccount(acc: UserAccount): UserAccount {
    let clonedAcc = new UserAccount();
    clonedAcc.accountId = acc.accountId;
    clonedAcc.login = acc.login;
    clonedAcc.password = acc.password;
    clonedAcc.email = acc.email;
    clonedAcc.role = Role.cloneRole(acc.role);
    clonedAcc.firstName = acc.firstName;
    clonedAcc.lastName = acc.lastName;
    return clonedAcc;
  }
}
