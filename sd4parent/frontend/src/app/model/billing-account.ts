export class BillingAccount {
  id: string;
  name: string;
  surname: string;
  email: string;

  static cloneBase(billingAccout: BillingAccount): BillingAccount {
    let clonedBillingAccount: BillingAccount = new BillingAccount();
    clonedBillingAccount.id = billingAccout.id;
    clonedBillingAccount.surname = billingAccout.surname;
    clonedBillingAccount.email = billingAccout.email;
    clonedBillingAccount.name = billingAccout.name;
    return clonedBillingAccount;
  }
}
