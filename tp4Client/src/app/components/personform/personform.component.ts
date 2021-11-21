import { Component, Input, OnInit, Output, EventEmitter, ElementRef, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Person } from 'src/app/types/person.types';

@Component({
  selector: 'app-personform',
  templateUrl: './personform.component.html',
  styleUrls: ['./personform.component.css']
})
export class PersonformComponent implements OnInit {
  form: FormGroup
  @Input() open: boolean
  @Input() person: Person
  @Output() save: EventEmitter<Person>
  @Output() close: EventEmitter<void>
  @ViewChild('el') el;

  constructor() {
    this.open = false
    this.save = new EventEmitter<Person>();
    this.close = new EventEmitter<void>();
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      id: new FormControl(this.person?.id),
      nom: new FormControl(this.person?.nom, Validators.required),
      age: new FormControl(this.person?.age, [Validators.required, Validators.min(1)]),
      nationality: new FormControl(this.person?.nationality, Validators.required),
    });
  }

  get nom() {
    return <FormControl>this.form.get("nom")
  }

  get age() {
    return <FormControl>this.form.get("age")
  }

  get nationality() {
    return <FormControl>this.form.get("nationality")
  }

  onSave(person: Person): void {
    this.save.emit(person);
    this.close.emit();
  }

  onClick(event) {
    if (this.el?.nativeElement?.contains(event?.target)) {
      return;
    }
    this.close.emit();
  }

}
