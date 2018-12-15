import {Component, OnInit, EventEmitter, Output, TemplateRef} from "@angular/core";
import { BsModalRef, BsModalService } from "ngx-bootstrap/modal";
import {User} from "../model/user";
import {Router} from "@angular/router";
import {BillingAccount} from "../model/billing-account";
import {Subscription} from "rxjs";
import {BillingAccountService} from "../service/billing/billing-account.service";
import {LoginUser} from "../model/loginUser";
import {AuthService} from "../service/auth.service";
import {TokenStorage} from "../service/token.storage";
import {UserService} from "../service/user.service";

@Component({
  selector: "app-signin-modal",
  templateUrl: "./signin-modal.component.html",
  styleUrls: ["./signin-modal.component.css"]
})
export class SigninModalComponent {
  @Output()
  public authorized: EventEmitter<boolean> = new EventEmitter<boolean>();
  public alertUser: boolean = false;

  private subscriptions: Subscription[] = [];

  modalRef: BsModalRef;
  modalRef2: BsModalRef;
  public editableUs: User = new User();
  public editableAcc: BillingAccount = new BillingAccount();

  loginUser: LoginUser = new LoginUser();

  constructor(private modalService: BsModalService, private router: Router, private billingAccountService: BillingAccountService) {}

  openModal(template: TemplateRef<any>) {
    if (this.modalRef2) {
      this.modalRef2.hide();
    }
    this.modalRef = this.modalService.show(template);
  }

  openModal2(template: TemplateRef<any>) {
    if (this.modalRef) {
      this.modalRef.hide();
    }
    this.modalRef2 = this.modalService.show(template, { class: "second" });
  }


}
