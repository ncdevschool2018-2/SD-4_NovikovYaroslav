import { BsModalService } from "ngx-bootstrap/modal";
import { BsModalRef } from "ngx-bootstrap/modal/bs-modal-ref.service";
import {Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ["./navbar.component.css"]
})
export class NavbarComponent implements OnInit {
  role = 'admin';

  constructor() {}

  ngOnInit() {}
}
