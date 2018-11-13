import { Component, OnInit, TemplateRef } from "@angular/core";
import { BsModalRef, BsModalService } from "ngx-bootstrap/modal";
import {User} from "../model/user";
import {BillingAccount} from "../model/billing-account";

@Component({
  selector: "app-signin-modal",
  templateUrl: "./signin-modal.component.html",
  styleUrls: ["./signin-modal.component.css"]
})
export class SigninModalComponent {
  modalRef: BsModalRef;
  modalRef2: BsModalRef;
  public editableUs: User = new User();
  public editableAcc: BillingAccount = new BillingAccount();
  constructor(private modalService: BsModalService) {}

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
