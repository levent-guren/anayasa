import { Component, OnInit } from '@angular/core';
import { Personel } from './../model/personel';
import { PersonelService } from './../service/personel.service';

@Component({
  selector: 'app-personel-listesi',
  templateUrl: './personel-listesi.component.html',
  styleUrls: ['./personel-listesi.component.scss']
})
export class PersonelListesiComponent implements OnInit {
  public personeller: Personel[] = [];

  constructor(private personelService: PersonelService) { }

  ngOnInit(): void {
    this.personelService.getPersoneller().subscribe({
      next: (data) => {
        this.personeller = data;
        this.personeller.forEach(
          p => {
            p.dogumTarihi = new Date(p.dogumTarihi);
          }
        );
      },
      error: (err) => {
        console.error(err);
      }
     });
  }
}
