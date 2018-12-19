import { Component, OnInit, TemplateRef } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription'
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserService} from "../service/user.service";
import {Purse} from "../model/purse";
import {PurseService} from "../service/purse.service";
import { MoneyOperation } from "../model/moneyOperation";
import { AuthService } from "../service/auth.service";
import {User} from "../model/user";
import {Product} from "../model/product";
import {BillingAccount} from "../model/billing-account";
import {BillingAccountService} from "../service/billing/billing-account.service";

@Component({
  selector: 'user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  public purse: Purse;
  public editablePurse: Purse = new Purse();
  public user: User;
  public amount: number;
  public editableUs: User = new User;
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  constructor(private userService: UserService,
              private billingAccountService: BillingAccountService,
              private modalService: BsModalService,
              private authService: AuthService, private purseService: PurseService) { }

  ngOnInit() {
    this.loadPurse(this.authService.getUsername());
  }

  private loadPurse(login: string) {
    this.subscriptions.push(this.userService.getUserByLogin(login).subscribe(account => {
      this.user = account as User;
      this._getPurseByOwnerId(account.id);
    }));
  }

  _getPurseByOwnerId(accountId: string) {
    this.subscriptions.push(this.purseService.getPurseByOwnerId(accountId).subscribe( purses => {
      this.purse = purses;
    }));
  }

  public _openModal(template: TemplateRef<any>, user: User) {
    this.editableUs = User.cloneBase(user);
    this.editableUs.role = this.user.role;
    this.editableUs.account = BillingAccount.cloneBase(this.user.account);
    this.modalRef = this.modalService.show(template);
  }

  public _addUser(): void {
    this.subscriptions.push(this.billingAccountService.saveBillingAccount(this.editableUs.account).subscribe(()=> {
      this.closeModal();
      this.loadPurse(this.authService.getUsername());
    }));
  }


  private closeModal(): void {
    this.modalRef.hide();
  }

}
