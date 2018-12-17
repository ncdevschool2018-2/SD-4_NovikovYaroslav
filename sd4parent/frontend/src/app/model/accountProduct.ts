import {User} from "./user";
import {BillingAccount} from "./billing-account";
import {Product} from "./product";
import {AccountId} from "./accountId";

export class AccountProduct {
  account: AccountId;
  product: Product;
  dateBeg: string;
  dateEnd: string;
}
