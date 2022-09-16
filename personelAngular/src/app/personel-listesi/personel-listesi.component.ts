import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Personel } from './../model/personel';
import { PersonelService } from './../service/personel.service';

@Component({
  selector: 'app-personel-listesi',
  templateUrl: './personel-listesi.component.html',
  styleUrls: ['./personel-listesi.component.scss']
})
export class PersonelListesiComponent implements OnInit {
  public personeller: Personel[] = [];
  public myForm: FormGroup;
  seciliPersonelIdleri: number[] = [];

  constructor(
    private personelService: PersonelService,
    private fb: FormBuilder,
    private toastr: ToastrService,
  ) {
    this.myForm = this.fb.group({
      secili: this.fb.array([])
    });
   }
  ngOnInit(): void {
    this.personelService.getPersoneller().subscribe({
      next: (data) => {
        this.personeller = data;
        const seciliArray = this.myForm.get('secili') as FormArray;
        this.personeller.forEach(
          p => {
            p.dogumTarihi = new Date(p.dogumTarihi);
            seciliArray.push(this.fb.control(false));
          }
        );

      },
      error: (err) => {
        console.error(err);
      }
     });
  }
  sil() {
    this.seciliPersonelIdleri = [];
    const secililer = this.myForm.get('secili')?.value;
    for (let i = 0; i < secililer.length; i++) {
      if (secililer[i]) {
        const seciliPersonel = this.personeller[i];
        this.seciliPersonelIdleri.push(seciliPersonel.id);
      }
    }
    this.personelService.personellerSil(this.seciliPersonelIdleri).subscribe({
      next: (result: any) => {
        if (result.sonuc === 'Başarılı') {
          this.toastr.success('Personeller silinmiştir.');
          this.personelleriSil();
        } else {
          this.toastr.error('Hata oluştu.');
        }
      },
      error: (err) => {
        console.error(err);
        this.toastr.error('Hata oluştu.');
      }
    });
  }
  personelleriSil() {
    this.seciliPersonelIdleri.forEach(id => this.personelSil(id));
  }
  personelSil(id: number) {
    const sira = this.personelSiraBul(id);
    this.personeller.splice(sira, 1);
    (this.myForm.controls['secili'] as FormArray).removeAt(sira);
  }
  personelSiraBul(id: number): number {
    for (let i = 0; i < this.personeller.length; i++) {
      if (this.personeller[i].id === id) {
        return i;
      }
    }
    return -1;
  }
}


