import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AccidentPage } from './accident.page';

describe('AccidentPage', () => {
  let component: AccidentPage;
  let fixture: ComponentFixture<AccidentPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(AccidentPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
