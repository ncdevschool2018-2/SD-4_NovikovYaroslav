import { BsModalService } from "ngx-bootstrap/modal";
import { BsModalRef } from "ngx-bootstrap/modal/bs-modal-ref.service";
import {Component, OnInit, TemplateRef} from "@angular/core";
import { Subscription } from 'rxjs/internal/Subscription';
import { AuthService } from "../service/auth.service";
import { Token } from "../model/token";
import {TokenStorage} from "../service/token.storage";
import { LoginUser } from "../model/loginUser";
import {Router} from "@angular/router";
import { Decode } from "../model/decode";
import {User} from "../model/user";
import { UserService } from '../service/user.service';
import {BillingAccount} from "../model/billing-account";
import {BillingAccountService} from "../service/billing/billing-account.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ["./navbar.component.css"]
})
export class NavbarComponent implements OnInit {
  public user: Decode;
  public role: string;
  public loginUser: LoginUser = new LoginUser();
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  public editableUs: User = new User();
  public editableAcc: BillingAccount = new BillingAccount();
  modalRef2: BsModalRef;

  constructor(private userService: UserService,private billingAccountService: BillingAccountService, private modalService: BsModalService,
              private router: Router,
              private authService: AuthService, private tokenStorage: TokenStorage) { }

  ngOnInit() {

    if(this.tokenStorage.getToken()) {
      this.user = this.authService.decodeJwt(this.tokenStorage.getToken());
      this.role = this.user.scopes;
    }

  }

  ngOnDestroy() {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>) {
    if (this.modalRef) {
      this.modalRef.hide();
    }
    else if(this.modalRef2) {
      this.modalRef2.hide();
    }
    this.modalRef = this.modalService.show(template);
  }

  public authorizate(): void {
    this.subscriptions.push(this.authService.attemptAuth(this.loginUser).subscribe(authToken => {
      let token: Token = authToken as Token;
      this.tokenStorage.saveToken(token.token);
      this.user = this.authService.decodeJwt(token.token);
      console.log(this.user);
      this.role = this.user.scopes;
      this._closeModal();
    }));

  }

  public signUp(): void {
    this.editableUs.role = "user";
    this.editableUs.account = this.editableAcc;
    this.subscriptions.push(this.userService.saveUser(this.editableUs).subscribe(()=> {
      this._closeModal();
    }));
  }

  private refreshUs(): void {
    this.editableUs = new User();
  }

  private refreshAcc(): void {
    this.editableUs = new User();
  }

  public signOut(): void {
    this.tokenStorage.signOut();
    this.user = undefined;
    this.router.navigate(['home']);
  }

}
