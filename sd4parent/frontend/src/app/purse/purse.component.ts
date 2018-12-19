import { Component, OnInit, TemplateRef } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription'
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserService} from "../service/user.service";
import {Purse} from "../model/purse";
import {PurseService} from "../service/purse.service";
import { MoneyOperation } from "../model/moneyOperation";
import { AuthService } from "../service/auth.service";
import {User} from "../model/user";

@Component({
  selector: 'app-purse',
  templateUrl: './purse.component.html',
  styleUrls: ['./purse.component.css']
})
export class PurseComponent implements OnInit {

  public purse: Purse;
  public editablePurse: Purse = new Purse();
  public user: User;
  public amount: number;
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  constructor(private userService: UserService,
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

  public _openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  private closeModal(): void {
    this.modalRef.hide();
  }

  public addPurse(): void {
    this.editablePurse.idAcc = this.user.id;
    console.log(this.editablePurse);
    this.subscriptions.push(this.purseService.savePurse(this.editablePurse).subscribe(() => {
      this.ngOnInit();
      this.closeModal();
    }));
  }

  public _fillUp(idWallet: string): void {

    let operation: MoneyOperation = new MoneyOperation();

    operation.amount = +this.amount;
    operation.id = idWallet;

    this.subscriptions.push(this.purseService.setMoney(operation).subscribe(result => {
      this.loadPurse(this.authService.getUsername());
      this.closeModal()
    }));
  }



}
