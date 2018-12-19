import {User} from "./user";

export class Purse {
  id:string;
  number: string;
  balance: number
  idAcc: string;

  static cloneBase(purse: Purse): Purse {
    let clonedPurse: Purse = new Purse();
    clonedPurse.number = purse.number;
    clonedPurse.balance = purse.balance;
    clonedPurse.idAcc = purse.idAcc;
    return clonedPurse;
  }

}
