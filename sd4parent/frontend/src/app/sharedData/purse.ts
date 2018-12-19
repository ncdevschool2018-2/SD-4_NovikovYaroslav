import { OnInit,  OnDestroy } from '@angular/core';
import {PurseService} from "../service/purse.service";
import {Purse} from "../model/purse";
import { Subscription } from 'rxjs/internal/Subscription';
//import { UpdateBalance } from '../model/updateWalletBalance';

export class PurseData implements OnInit, OnDestroy {

  editPurse: Purse = new Purse();
  purseMas: Purse[];
  private subscriptions: Subscription[] = [];
  isLoad = false;
  editMode = false;
  purseByOwnerId: Purse;

  ngOnInit(): void {
    this._loadPurse();
  }

  constructor( private purseService: PurseService) {}

  public _addPurse(): void {
    this.subscriptions.push(this.purseService.savePurse(this.editPurse).subscribe(() => {
      this._updatePurse();
      this.refreshPurse();
    }));
  }

  refreshPurse(): void {
    this.editPurse = new Purse();
  }

  _updatePurse(): void {
    this._loadPurse();
  }

  _deletePurse(purse_id: string): void {
    this.subscriptions.push(this.purseService.deletePurse(purse_id).subscribe( () => {
      this._updatePurse();
      this.refreshPurse();
    }));

  }
  _loadPurse(): void {
    this.subscriptions.push(this.purseService.getPurses().subscribe( purses => {
      this.purseMas = purses;
      this.isLoad = true;
    }));
  }

  _getPurseById(id: string): Purse {
    let purseById: Purse;
    this.subscriptions.push(this.purseService.getPurse(id).subscribe( purses => {
      purseById = purses;
    }));
    return purseById;
  }

  _getPurseByOwnerId(accountId: string) {
    this.subscriptions.push(this.purseService.getPurseByOwnerId(accountId).subscribe( purses => {
      this.purseByOwnerId = purses;
      this.isLoad = true;
    }));
  }

/*  _updateBalance(updateBalance: UpdateBalance) {
    this.subscriptions.push(this.walletService.updateWalletBalance(updateBalance).subscribe(() => {
    }));
  }*/

  ngOnDestroy(): void {
    this.subscriptions.forEach( subscription =>  subscription.unsubscribe());
  }

}
