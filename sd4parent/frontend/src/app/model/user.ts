import {Role} from "./role";
import {BillingAccount} from "./billing-account";

export class User {
  id: string;
  login: string;
  password: string;
  role: "user";
  account: BillingAccount;
}
