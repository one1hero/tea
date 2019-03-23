import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutorderComponent } from './outorder.component';

describe('OutorderComponent', () => {
  let component: OutorderComponent;
  let fixture: ComponentFixture<OutorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
