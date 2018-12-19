import { OnInit, OnDestroy, Input } from '@angular/core';
import {User} from '../model/user';
import { UserService } from '../service/user.service';
import { Subscription } from 'rxjs/internal/Subscription';
import {BillingAccount} from "../model/billing-account";
import { Role } from '../model/role';
import { AuthService } from '../service/auth.service';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

export class UserData implements OnInit, OnDestroy {

  passwordRepeat: string;
  editMode = false;
  editUser =  new User();
  userAccount: User[];
  userByLogin = new User();
  isLoad = false;

  private subscriptions: Subscription[] = [];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this._loadUser();
    this.editUser.account = new BillingAccount();
  }


  _addUser(): void {
    this.subscriptions.push(this.userService.saveUser
    (this.editUser).subscribe(() => {
      this._updateUser();
      this.refreshUser();
    }));
  }

  _updateUser(): void {
    this._loadUser();
  }

  refreshUser(): void {
    this.editUser = new User();
  }

  _deleteUser(userId: string): void {
    this.subscriptions.push(this.userService.deleteUser(userId).subscribe(() => {
      this._updateUser();
      this.refreshUser();
    }));
  }

  _loadUser(): void {
    // Get data from BillingAccountService
    this.subscriptions.push(this.userService.getUsers().subscribe(users => {
      this.userAccount = users;
      this.isLoad = true;
    }));
  }

  _getUserByLogin(login: string) {
    this.subscriptions.push(this.userService.getUserByLogin(login).subscribe( user => {
      this.userByLogin = user;
      this.isLoad = true;
    }));
  }

  userIdByLogin(login: string): string {
    return this.userByLogin.id;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription =>
      subscription.unsubscribe());
  }
}
